package com.garyohosu.barcodereader.domain

enum class ScanPhase {
    IDLE,
    WAITING_FOR_FIRST,
    WAITING_FOR_SECOND,
    RESULT
}
