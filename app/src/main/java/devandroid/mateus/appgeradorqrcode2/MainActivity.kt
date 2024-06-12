package devandroid.mateus.appgeradorqrcode2

import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter

class MainActivity : AppCompatActivity() {

    private lateinit var editQRCode: EditText
    private lateinit var btnGerarQRCode: Button
    private lateinit var imgQRCode: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponentes()

        btnGerarQRCode.setOnClickListener {
            if (TextUtils.isEmpty(editQRCode.text.toString())) {
                editQRCode.error = "*"
                editQRCode.requestFocus()
            } else {
                gerarQRCode(editQRCode.text.toString())
            }
        }
    }

    private fun gerarQRCode(conteudoQRCode: String) {
        val qrCode = QRCodeWriter()

        try {
            val bitMatrix = qrCode.encode(conteudoQRCode, BarcodeFormat.QR_CODE, 196, 196)
            val width = bitMatrix.width
            val height = bitMatrix.height

            val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)

            for (x in 0 until width) {
                for (y in 0 until height) {
                    bitmap.setPixel(x, y, if (bitMatrix[x, y]) Color.BLACK else Color.WHITE)
                }
            }

            imgQRCode.setImageBitmap(bitmap)

        } catch (e: WriterException) {
            e.printStackTrace()
        }
    }

    private fun initComponentes() {
        editQRCode = findViewById(R.id.editQRCode)
        btnGerarQRCode = findViewById(R.id.btnGerarQRCode)
        imgQRCode = findViewById(R.id.imgQRCode)
    }
}
