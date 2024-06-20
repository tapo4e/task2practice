package com.example.onboarding.details

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.onboarding.util.OnPage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@Composable
fun Loader(
    modifier: Modifier = Modifier,
    onPage: OnPage,
    pager: PagerState,
    scope: CoroutineScope
) {

    Box(
        modifier
            .padding(bottom = 36.dp, end = 40.dp)
            .size(70.dp)
            .graphicsLayer {
                clip = true
                shape = CircleShape
            }
            .background(Color(onPage.color)),
        contentAlignment = Alignment.Center
    )
    {

        Canvas(modifier.fillMaxSize()) {
            val width = size.width
            width / 2f
            val strokeWidth = 4.dp.toPx()
            drawArc(
                color = Color.White,
                startAngle = -90f,
                sweepAngle = (90 * (pager.currentPage + 1)).toFloat(),
                useCenter = false,
                topLeft = Offset(strokeWidth / 2, strokeWidth / 2),
                size = Size(width - strokeWidth, width - strokeWidth),
                style = Stroke(strokeWidth)
            )
        }
        Canvas(modifier.fillMaxSize()) {
            val width = size.width
            val strokeWidth = 4.dp.toPx()
            drawArc(
                color = Color.White.copy(alpha = 0.6f),
                startAngle = -90f,
                sweepAngle = 360f,
                useCenter = false,
                topLeft = Offset(strokeWidth / 2, strokeWidth / 2),
                size = Size(width - strokeWidth, width - strokeWidth),
                style = Stroke(strokeWidth)
            )
        }
        Box(
            modifier
                .size(50.dp)
                .graphicsLayer {
                    clip = true
                    shape = CircleShape
                }
                .background(Color.White)
                .clickable {
                    scope.launch {
                        pager.animateScrollToPage(pager.currentPage + 1)
                    }
                },
            contentAlignment = Alignment.Center,
        ) {
            Box(
                modifier
                    .padding(start = 3.dp)
                    .drawWithCache {
                        val path = Path()
                        path.moveTo(0f, 0f)
                        path.lineTo(size.width, size.height / 2f)
                        path.lineTo(0f, size.height)
                        onDrawBehind {
                            drawPath(
                                path,
                                color = Color(onPage.color),
                                style = Stroke(
                                    width = 7f,
                                    pathEffect = PathEffect.cornerPathEffect(2.dp.toPx()),
                                    cap = StrokeCap.Round
                                )
                            )
                        }
                    }
                    .width(8.dp)
                    .height(15.dp)
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun PreviewLoader() {
    Loader(
        onPage = OnPage.First,
        pager = rememberPagerState(initialPage = 0) { 0 },
        scope = rememberCoroutineScope()
    )
}