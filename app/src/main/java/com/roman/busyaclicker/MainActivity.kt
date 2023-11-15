package com.roman.busyaclicker

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var clickCounter: TextView
    private lateinit var clickBtn: ImageButton
    private var counter = 0
    private var mMediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clicksCounter()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("savedClicks", counter)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val restoredNumber = savedInstanceState.getInt("savedClicks", 0)
        counter = restoredNumber
        "Кошка нажата $counter раз".also { clickCounter.text = it }

    }

    private fun playPurr() {
        if (mMediaPlayer == null) {
            mMediaPlayer = MediaPlayer.create(this, R.raw.catpurr)
            mMediaPlayer!!.start()
        } else mMediaPlayer!!.start()
    }

    private fun clicksCounter() {
        clickCounter = findViewById(R.id.click_counter)
        clickBtn = findViewById(R.id.btn_clicker)

        clickBtn.setOnClickListener {
            counter++
            updateText()
            if (counter == 100) playPurr()
        }
    }

    private fun updateText() {
        clickCounter.text = "Кошка нажата $counter раз"
    }


}