package udl.eps.manejoserviciokotlininc

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast

class ElServicio : Service() {

    private var soundplayer: MediaPlayer? = null
    private var songplayer: MediaPlayer? = null

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onCreate() {
        super.onCreate()
        Toast.makeText(this, R.string.creaserv, Toast.LENGTH_SHORT).show()

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)

        val type = intent!!.getStringExtra("mp3")
        if (type == "playSound") {
            Toast.makeText(this, R.string.serviceSound, Toast.LENGTH_SHORT).show()
            soundplayer = MediaPlayer.create(applicationContext, R.raw.train)
            soundplayer!!.isLooping = true
            soundplayer!!.start()
        } else if (type == "playSong") {
            Toast.makeText(this, R.string.serviceSong, Toast.LENGTH_SHORT).show()
            songplayer = MediaPlayer.create(applicationContext, R.raw.song)
            songplayer!!.isLooping = true
            songplayer!!.start()
        }

        return startId
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, R.string.finaserv, Toast.LENGTH_SHORT).show()
        if (soundplayer?.isPlaying == true)
            soundplayer!!.stop()
        if (songplayer?.isPlaying == true)
            songplayer!!.stop()
    }
}