package com.devedroy.qrbarcode

interface ScanningResultListener {
    fun onScanned(result: String)
}