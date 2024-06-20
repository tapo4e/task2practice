package com.example.onboarding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.onboarding.ui.theme.OnBoardingTheme


class MainActivity : ComponentActivity() {

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OnBoardingTheme {
                LayoutOfWindows()

            }
        }
    }

    @ExperimentalFoundationApi
    @Preview
    @Composable
    fun GreetingPreview() {
        LayoutOfWindows()
    }

}







