package udl.eps.manejoserviciokotlininc

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class soundsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val serviceInt = Intent(context, ElServicio::class.java)

        if (intent?.action.equals(Intent.ACTION_HEADSET_PLUG)) {
            Toast.makeText(context, "Haedset Plug", Toast.LENGTH_SHORT).show()
            when (intent!!.getIntExtra("state", -1)) {
                0 -> {
                    Toast.makeText(context, "BroadcastReceiver - HEADSET_PLUG-OFF", Toast.LENGTH_SHORT).show()
                    context?.stopService(serviceInt)
                }

                1 -> {
                    Toast.makeText(context, "BroadcastReceiver - HEADSET_PLUG-ON", Toast.LENGTH_SHORT).show()
                    serviceInt.putExtra("mp3", "playSong")
                    context?.startService(serviceInt)
                }
            }
        } else {
            val type = intent!!.getStringExtra("mp3")

            if (type == "stop") {
                Toast.makeText(context, R.string.broadcastStop, Toast.LENGTH_SHORT).show()
                context?.stopService(serviceInt)
            }

            if (type == "playSound") {
                Toast.makeText(context, R.string.broadcastSound, Toast.LENGTH_SHORT).show()
                serviceInt.putExtra("mp3", type)
            } else if (type == "playSong") {
                Toast.makeText(context, R.string.broadcastSong, Toast.LENGTH_SHORT).show()
                serviceInt.putExtra("mp3", type)
            }

            context?.startService(serviceInt)
        }

    }
}