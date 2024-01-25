package com.devedroy.qrbarcode

import android.content.Context
import android.content.Intent

object BarcodeViewController {

    fun triggerBarcode(context: Context)  = context.startActivity(Intent(context, MainActivity::class.java))

}