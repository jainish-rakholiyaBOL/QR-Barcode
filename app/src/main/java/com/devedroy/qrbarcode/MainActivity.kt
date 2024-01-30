package com.devedroy.qrbarcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.devedroy.qrbarcode.databinding.ActivityMainBinding
import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.Settings
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.app.ActivityCompat

class QRScanner(private val ctx: Context, val attributeSet: AttributeSet) : LinearLayout(ctx, attributeSet) {
    private val CAMERA_PERMISSION_CODE = 123

    private val binding = ActivityMainBinding.inflate(LayoutInflater.from(context), this, true)
    init {
        binding.btnScan.setOnClickListener {
            triggerScan()
        }
    }


    private fun triggerScan() {
        if (ContextCompat.checkSelfPermission(
                context, Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            openScanner()
        } else {
            ActivityCompat.requestPermissions(
                context as Activity, arrayOf(Manifest.permission.CAMERA), CAMERA_PERMISSION_CODE
            )
        }
    }

    private fun openScanner() {
        context.startActivity(Intent(context, BarCodeScannerActivity::class.java))
    }

}