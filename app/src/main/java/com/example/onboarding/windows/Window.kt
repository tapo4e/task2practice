package com.example.onboarding.windows

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.onboarding.R
import com.example.onboarding.util.OnPage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext


@Composable
fun Greeting(modifier: Modifier = Modifier,onPage:OnPage) {
    Box(
        modifier
            .fillMaxSize()
            .background(Color(onPage.color)),
    ) {
        Column(
            modifier
                .padding(
                    start = 30.dp,
                    top = 50.dp,
                )
                .align(Alignment.TopStart)
        ) {
            Text(
                text = onPage.title ,
                fontWeight = Bold,
                fontSize = 28.sp,
                color = Color.White,
                style = TextStyle(
                    lineHeight = 1.2.em
                )
            )
            Text(
                text = onPage.text,
                color = Color.White,
                fontSize = 18.sp,
            )
        }
        Image(
            painter = painterResource(id = onPage.image), contentDescription = null,
            modifier
                .padding(top = 70.dp)
                .fillMaxSize()

        )
        //Loader()
    }
}


@Preview
@Composable
fun GreetingPreview() {
Greeting(onPage= OnPage.Second)
}



