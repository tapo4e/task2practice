package com.example.onboarding.util

import androidx.annotation.DrawableRes
import com.example.onboarding.R

sealed class OnPage
    (
    @DrawableRes
    val image: Int,
    val title: String,
    val text: String,
    val color: Long,
    val finalWindow: Boolean
) {
    data object First : OnPage(
        image = R.drawable.img_car1,
        title = "Your first car without\na drivers license",
        text = "Goes to meet people who just got\ntheir license",
        color = 0xFFF2D478,
        finalWindow = false
    )

    data object Second : OnPage(
        image = R.drawable.img_car2,
        title = "Always there: more than\n1000 cars in Tbilisi",
        text = "Our company is a leader by the\nnumber of cars in the fleet",
        color = 0xFFB7ABFC,
        finalWindow = false
    )

    data object Third : OnPage(
        image = R.drawable.img_car3,
        title = "Do not pay for parking,\nmaintenance and gasoline",
        text = "We will pay for you, all expenses\nrelated to the car",
        color = 0xFFEFB491,
        finalWindow = false
    )

    data object Four : OnPage(
        image = R.drawable.img_car4,
        title = "29 car models: from Skoda\nOctavia to Porsche 911",
        text = "Choose between regular car models \nor exclusive ones",
        color = 0xFF95B6FF,
        finalWindow = false
    )
    data object Five:OnPage(
        image = 0,
        title = "You are a clever person!",
        text = "",
        color = 0xFF95B6FF,
        finalWindow = true
    )
}