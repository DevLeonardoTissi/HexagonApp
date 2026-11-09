package br.com.leonardo.appcore.presentation.utils

import android.graphics.Bitmap
import androidx.core.graphics.createBitmap
import androidx.core.graphics.set
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter

/**
 * Generates a bitmap QR Code image for the given text.
 *
 * @param text Content string to encode into the QR code.
 * @return [Bitmap] image representation of the QR code.
 */
fun generateQrCode(text: String): Bitmap {
    val matrix = QRCodeWriter().encode(text, BarcodeFormat.QR_CODE, 512, 512)
    val width = matrix.width
    val height = matrix.height

    val bitmap = createBitmap(width, height, Bitmap.Config.RGB_565)

    for (y in 0 until height) {
        for (x in 0 until width) {
            bitmap[x, y] =
                if (matrix.get(x, y)) android.graphics.Color.BLACK else android.graphics.Color.WHITE
        }
    }

    return bitmap
}
