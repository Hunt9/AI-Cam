package com.ahkam.aicam

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ahkam.aicam.databinding.ActivityPreviewBinding


class PreviewActivity : AppCompatActivity() {


    private lateinit var activityPreviewBinding: ActivityPreviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityPreviewBinding = ActivityPreviewBinding.inflate(layoutInflater)
        setContentView(activityPreviewBinding.root)

        var bmp: Bitmap? = null
        val filename = intent.getStringExtra("image")
        try {
            val inputsStream = openFileInput(filename)
            bmp = BitmapFactory.decodeStream(inputsStream)

            activityPreviewBinding.preview.setImageBitmap(bmp)

            inputsStream.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}