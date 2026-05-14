package com.garyohosu.barcodereader.domain

data class ScanState(
    val phase: ScanPhase = ScanPhase.IDLE,
    val barcode1: String? = null,
    val barcode2: String? = null,
    val result: ScanResult? = null,
    val errorMessage: String? = null,
    val permissionDenied: Boolean = false
)
