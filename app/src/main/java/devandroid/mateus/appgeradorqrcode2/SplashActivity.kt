package devandroid.mateus.appgeradorqrcode2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    private val TIME_OUT_SPLASH = 3000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        initSplash()
    }

    private fun initSplash() {
        Handler(Looper.getMainLooper()).postDelayed({
            val telaPrincipal = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(telaPrincipal)
            finish()
        }, TIME_OUT_SPLASH)
    }
}
