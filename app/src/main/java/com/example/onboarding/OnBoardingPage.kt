package com.example.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onboarding.details.Loader
import com.example.onboarding.details.WormIndicator
import com.example.onboarding.util.OnPage
import com.example.onboarding.windows.Greeting
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@Composable
fun LayoutOfWindows(modifier: Modifier = Modifier) {
    val listOfWindows =
        listOf(OnPage.First, OnPage.Second, OnPage.Third, OnPage.Four, OnPage.Five)
    val pageState = rememberPagerState(initialPage = 0) { listOfWindows.size }

    Box(
        modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        HorizontalPager(
            state = pageState,
        ) { page ->
            Greeting(onPage = listOfWindows[page])
        }
        val coroutineScope = rememberCoroutineScope()
        if(pageState.currentPage!=4) {
            Loader(
                onPage = listOfWindows[pageState.currentPage],
                pager = pageState,
                scope = coroutineScope
            )
            Column(
                modifier
                    .padding(bottom = 40.dp, start = 50.dp)
                    .align(Alignment.BottomStart)
            ) {

                WormIndicator(count = listOfWindows.size - 1, pagerState = pageState)
                Spacer(modifier.height(8.dp))
                Text(
                    text = "Skip",
                    modifier.clickable {
                        coroutineScope.launch { pageState.animateScrollToPage(4) }
                    },
                    fontSize = 25.sp,
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.abel_regular))
                )
            }
        }

    }
}