package com.example.indicatorsdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.RatingBar
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tv = findViewById<TextView>(R.id.textView)
        var rb = findViewById<RatingBar>(R.id.ratingBar)
        rb.setOnRatingBarChangeListener { ratingBar, fl, b ->
            tv.setText("Rating = $fl")
        }

        var tv3 = findViewById<TextView>(R.id.textView3)
        var pb = findViewById<ProgressBar>(R.id.progressBar)


        var count = 0
        Thread(
            Runnable {
                while (count<100){
                    count+=10
                    pb.progress = count
                    Thread.sleep(1000)
                    runOnUiThread {
                        tv3.setText("Value=$count")
                    }
                }
            }
        ).start()

        
        var tv2 = findViewById<TextView>(R.id.textView2)
        var sb = findViewById<SeekBar>(R.id.seekBar)
        sb.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                tv2.setText("Value=$p1")
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
    }
}