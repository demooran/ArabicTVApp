package com.example.arabictv

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    data class Channel(val name: String, val url: String)

    private val channels = listOf(
        Channel("القناة 1","https://technomaster.pro/hls/a0a.l.cIlchannel1-stream.Iil8906541.m3u8"),
        Channel("القناة 2","https://technomaster.pro/hls/a0a.l.cIlchannel2-stream.Iil8906541.m3u8"),
        Channel("القناة 3","https://technomaster.pro/hls/a0a.l.cIlchannel3-stream.Iil8906541.m3u8"),
        Channel("القناة 4","https://technomaster.pro/hls/a0a.l.cIlchannel4-stream.Iil8906541.m3u8"),
        Channel("القناة 5","https://technomaster.pro/hls/t0t.cIlchannel5-stream.Iil8906541.m3u8"),
        Channel("القناة 6","https://technomaster.pro/hls/a0a.l.cIlchannel6-stream.Iil8906541.m3u8"),
        Channel("القناة 7","https://technomaster.pro/hls/a0a.l.cIlchannel7-stream.Iil8906541.m3u8"),
        Channel("القناة 8","https://technomaster.pro/hls/a0a.l.cIlchannel8-stream.Iil8906541.m3u8"),
        Channel("القناة 9","https://technomaster.pro/hls/a0a.l.cIlchannel9-stream.Iil8906541.m3u8")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val rv = RecyclerView(this)
        rv.layoutManager = GridLayoutManager(this, 3)
        setContentView(rv)

        rv.adapter = ChannelAdapter(channels) {
            val i = Intent(this, PlayerActivity::class.java)
            i.putExtra("url", it.url)
            startActivity(i)
        }
    }
}
