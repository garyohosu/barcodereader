package com.garyohosu.barcodereader.camera

import androidx.camera.core.ExperimentalGetImage
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.common.InputImage

class BarcodeAnalyzer(
    private val onDetected: (String?) -> Unit
) : ImageAnalysis.Analyzer {

    private val scanner = BarcodeScanning.getClient()

    @ExperimentalGetImage
    override fun analyze(imageProxy: ImageProxy) {
        val mediaImage = imageProxy.image
        if (mediaImage == null) {
            imageProxy.close()
            return
        }

        val image = InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)

        scanner.process(image)
            .addOnSuccessListener { barcodes ->
                if (barcodes.isNotEmpty()) {
                    // バーコードを検出したが rawValue が null/blank の場合も ViewModel に通知する
                    onDetected(barcodes.first().rawValue)
                }
                // バーコードが1枚も検出されなかった場合は何もしない（次フレームを待つ）
            }
            .addOnFailureListener {
                onDetected(null)
            }
            .addOnCompleteListener {
                imageProxy.close()
            }
    }
}
