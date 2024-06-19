package com.example.onboarding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.onboarding.details.Loader
import com.example.onboarding.details.WormIndicator
import com.example.onboarding.ui.theme.OnBoardingTheme
import com.example.onboarding.util.OnPage
import com.example.onboarding.windows.Greeting

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
    @Composable
    fun LayoutOfWindows(modifier: Modifier = Modifier) {
        val listOfWindows = listOf(OnPage.First,OnPage.Second,OnPage.Third,OnPage.Four)
        val pageState = rememberPagerState(initialPage = 0){listOfWindows.size}

        Box(modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomEnd) {
            HorizontalPager(
                state = pageState,
            ) { page ->
                Greeting(onPage = listOfWindows[page])
            }
            Loader(
                onPage = listOfWindows[pageState.currentPage],
                pager = pageState,
                scope = rememberCoroutineScope()
            )
        }
        WormIndicator(count = listOfWindows.size, pagerState = pageState)

    }


    @ExperimentalFoundationApi
    @Preview
    @Composable
    fun GreetingPreview() {
        LayoutOfWindows()
    }

}







