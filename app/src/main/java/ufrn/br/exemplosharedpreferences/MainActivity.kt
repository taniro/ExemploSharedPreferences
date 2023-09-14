package ufrn.br.exemplosharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import ufrn.br.exemplosharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    override fun onStop() {
        super.onStop()
        var preferences = getPreferences(MODE_PRIVATE)
        val preferences_editor = preferences.edit()
        preferences_editor.putString("campo", binding.editText.text.toString())
        preferences_editor.apply()
    }

    override fun onStart() {
        super.onStart()
        var preferences = getPreferences(MODE_PRIVATE)
        var campo = preferences.getString("campo", "")
        binding.editText.setText(campo)
    }
}