package com.megamind.mybitmap

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Get the screen's density scale
        val scale: Float = resources.displayMetrics.density
        val densityDpi: Int = resources.displayMetrics.densityDpi
        txtDensityAndDensityDpi.text = "density : ${scale}, densityDpi : $densityDpi"

        val options = BitmapFactory.Options().apply {
            inJustDecodeBounds = true
        }
        BitmapFactory.decodeResource(resources, R.drawable.xxhdpi, options)
        val imageHeight: Int = options.outHeight
        val imageWidth: Int = options.outWidth
        val imageType: String = options.outMimeType

        txtImageWidthHeight.text = "width:${imageWidth}, height:${imageHeight}, imageType:$imageType"

        options.apply {
            inJustDecodeBounds = false
        }
        val xxhBitmap = BitmapFactory.decodeResource(resources, R.drawable.xxhdpi, options)
        txtXxhdpiMemorySize.text = "xxhdpi : ${xxhBitmap.byteCount}B"

        val xhBitmap = BitmapFactory.decodeResource(resources, R.drawable.xhdpi)
        txtXhdpiMemorySize.text = "xhdpi : ${xhBitmap.byteCount}B"

    }


}