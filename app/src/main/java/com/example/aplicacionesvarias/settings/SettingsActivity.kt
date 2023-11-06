package com.example.aplicacionesvarias.settings


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.aplicacionesvarias.databinding.ActivitySettingsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch


//Mediante ese delegado "by preferencesDataStore" hacemos que solo haya una instancia de esta
//base de datos. Como un singeltone
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsActivity : AppCompatActivity() {

    companion object {
        const val VOLUME_LVL = "volume_lvl"
        const val KEY_BLUETOOTH = "key_bluetooth"
        const val KEY_VIBRATION = "key_vibration"
        const val KEY_DARK_MODE = "key_dark_mode"
    }

    private lateinit var bindig: ActivitySettingsBinding
    private var firsTime:Boolean=true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindig = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(bindig.root)
        CoroutineScope(Dispatchers.IO).launch {

            getSettings().filter { firsTime }.collect{settingsModel->
                if (settingsModel!=null){
                    runOnUiThread {
                        bindig.SwitchVibration.isChecked = settingsModel.vibration
                        bindig.SwitchBluetooth.isChecked = settingsModel.bluetooth
                        bindig.SwitchDarkMode.isChecked = settingsModel.darkMode
                        bindig.rsVolume.setValues(settingsModel.volume.toFloat())
                        firsTime=!firsTime
                    }

            }

            }
        }

        initUI()
    }

    private fun initUI() {
        bindig.rsVolume.addOnChangeListener { _, value, _ ->
            Log.i("JoseLuis", "El Valor es $value")
            CoroutineScope(Dispatchers.IO).launch {
                saveVolume(value.toInt())
            }
        }

        bindig.SwitchBluetooth.setOnCheckedChangeListener { _, value ->
            CoroutineScope(Dispatchers.IO).launch {
                saveOptions(KEY_BLUETOOTH, value)
            }
        }
        bindig.SwitchVibration.setOnCheckedChangeListener { _, value ->
            CoroutineScope(Dispatchers.IO).launch {
                saveOptions(KEY_VIBRATION, value)
            }
        }
        bindig.SwitchDarkMode.setOnCheckedChangeListener { _, value ->
            if(value){
                enableDarkMode()
            }else{
                disableDarkMode()
            }
            CoroutineScope(Dispatchers.IO).launch {
                saveOptions(KEY_DARK_MODE, value)
            }
        }

    }

    private suspend fun saveVolume(value: Int) {
        dataStore.edit { preferences ->
            preferences[intPreferencesKey(VOLUME_LVL)] = value
        }
    }

    private suspend fun saveOptions(key: String, value: Boolean) {

        dataStore.edit { preferences ->
            preferences[booleanPreferencesKey(key)] = value
        }

    }

    /**
     * Recupera los datos guardados
     *
     */
    private fun getSettings(): Flow<SettingsModel?> {
        return dataStore.data.map { preferences ->
            SettingsModel(
                darkMode = preferences[booleanPreferencesKey(KEY_DARK_MODE)]?:false,
                bluetooth = preferences[booleanPreferencesKey(KEY_BLUETOOTH)]?:true,
                volume = preferences[intPreferencesKey(VOLUME_LVL)]?:50,
                vibration = preferences[booleanPreferencesKey(KEY_VIBRATION)]?:true

            )


        }


    }


    private fun enableDarkMode(){
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
        delegate.applyDayNight()

    }
    private fun disableDarkMode(){
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
        delegate.applyDayNight()

    }
}














