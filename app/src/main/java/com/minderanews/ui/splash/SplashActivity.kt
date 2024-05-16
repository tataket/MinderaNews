package com.minderanews.ui.splash

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.minderanews.MainActivity
import com.minderanews.databinding.ActivitySplashBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity() {

    private val viewModel: SplashViewModel by viewModel()

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onConfigLoaded()
        observable()
    }

    private fun observable() {
        with(lifecycleScope) {
            launch {
                viewModel.navigate.collect {
                    if (it == true) {
                        startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                    } else if (it == false) {
                        startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                        // findNavController().navigate() login
                    }
                }
            }
        }
    }
    private fun onConfigLoaded() {
        binding.splashAnimation.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {

            }

            override fun onAnimationEnd(animation: Animator) {
                viewModel.isExistUserAuth()
            }

            override fun onAnimationCancel(animation: Animator) {

            }

            override fun onAnimationRepeat(animation: Animator) {

            }
        })
    }
}