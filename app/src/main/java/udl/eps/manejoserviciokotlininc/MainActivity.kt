package udl.eps.manejoserviciokotlininc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import udl.eps.manejoserviciokotlininc.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSound.setOnClickListener(this)
        binding.btnSong.setOnClickListener(this)
        binding.btnFin.setOnClickListener(this)

    }

    override fun onClick(src: View) {
        val intent = Intent(this, ElServicio::class.java)
        when (src.id) {
            R.id.btnSound -> {
                intent.putExtra("mp3", "sound")
                Toast.makeText(this, R.string.soundtype, Toast.LENGTH_SHORT).show()
                startService(intent)
            }

            R.id.btnSong -> {
                intent.putExtra("mp3", "song")
                Toast.makeText(this, R.string.songtype, Toast.LENGTH_SHORT).show()
                startService(intent)
            }

            R.id.btnFin -> stopService(intent)
        }
    }
}