package com.roman.busyaclicker

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.roman.busyaclicker.databinding.ActivityMainBinding


class MainViewModel : ViewModel() {
    var counter: Int = 0
}

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private var mMediaPlayer: MediaPlayer? = null
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clicksCounter()
        updateText()
    }

    private fun playPurr() {
        if (mMediaPlayer == null) {
            mMediaPlayer = MediaPlayer.create(this, R.raw.catpurr)
            mMediaPlayer!!.start()
        } else mMediaPlayer!!.start()
    }

    private fun clicksCounter() {
        binding.btnClicker.setOnClickListener {
            mainViewModel.counter++
            updateText()
            if (mainViewModel.counter == 100) playPurr()
        }
    }

    private fun updateText() {
        binding.clickCounter.text = "Кошка нажата ${mainViewModel.counter} раз"
    }


}