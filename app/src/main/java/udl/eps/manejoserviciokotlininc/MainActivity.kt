package udl.eps.manejoserviciokotlininc

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import udl.eps.manejoserviciokotlininc.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var receiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSound.setOnClickListener(this)
        binding.btnSong.setOnClickListener(this)
        binding.btnFin.setOnClickListener(this)

        receiver = soundsReceiver()
        val filter = IntentFilter()
        filter.addAction("android.intent.action.HEADSET_PLUG")
        registerReceiver(receiver, filter)

    }

    override fun onClick(src: View) {
        val intent = Intent(this, soundsReceiver::class.java)
        when (src.id) {
            R.id.btnSound -> {
                intent.putExtra("mp3", "playSound")
                Toast.makeText(this, R.string.soundtype, Toast.LENGTH_SHORT).show()
            }

            R.id.btnSong -> {
                intent.putExtra("mp3", "playSong")
                Toast.makeText(this, R.string.songtype, Toast.LENGTH_SHORT).show()
            }

            R.id.btnFin -> {
                intent.putExtra("mp3", "stop")
            }
        }
        sendBroadcast(intent)
    }
}