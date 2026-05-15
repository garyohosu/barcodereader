package com.garyohosu.barcodereader.data

import android.content.Context

class SettingsRepository(context: Context) {

    private val prefs = context.getSharedPreferences("barcode_settings", Context.MODE_PRIVATE)

    var targetCount: Int
        get() = prefs.getInt("target_count", 0)
        set(value) { prefs.edit().putInt("target_count", value).apply() }

    var barcodeLength: Int
        get() = prefs.getInt("barcode_length", 0)
        set(value) { prefs.edit().putInt("barcode_length", value).apply() }

    var barcodeHeader: String
        get() = prefs.getString("barcode_header", "") ?: ""
        set(value) { prefs.edit().putString("barcode_header", value).apply() }
}
