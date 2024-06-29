package com.myapp.dreamydrakor

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)

        val ivSplashScreen = findViewById<ImageView>(R.id.iv_splash_screen)
        ivSplashScreen.alpha = 0.2f
        ivSplashScreen.animate().setDuration(1500).alpha(1f).withEndAction {
            val splashScreen = Intent(this, MainActivity::class.java)
            startActivity(splashScreen)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}