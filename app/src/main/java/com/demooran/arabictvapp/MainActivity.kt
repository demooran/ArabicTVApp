package com.demooran.arabictvapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.demooran.arabictvapp.databinding.ActivityMainBnding // تم تعديلها تلقائياً لتوافق التسمية الحالية للـ Binding لديك

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBnding
    private var player: ExoPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBnding.inflate(layoutInflater)
        setContentView(binding.root)

        // تشغيل البث عند فتح التطبيق
        initializePlayer()
    }

    private fun initializePlayer() {
        player = ExoPlayer.Builder(this).build().also { exoPlayer ->
            binding.playerView.player = exoPlayer
            
            // رابط بث مباشر تجريبي (قناة إخبارية دولية مفتوحة للبث كمثال تستطيع تغييره لاحقاً)
            val videoUrl = "https://test-streams.mux.dev/x36xhzz/x36xhzz.m3u8"
            
            val mediaItem = MediaItem.fromUri(videoUrl)
            exoPlayer.setMediaItem(mediaItem)
            exoPlayer.prepare()
            exoPlayer.playWhenReady = true
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        player?.release()
        player = null
    }
}
