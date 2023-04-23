package udl.eps.manejoserviciokotlininc

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class soundsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val serviceInt = Intent(context, ElServicio::class.java)
        val type = intent!!.getStringExtra("mp3")
        println(type)

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