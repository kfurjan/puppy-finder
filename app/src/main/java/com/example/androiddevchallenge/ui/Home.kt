package com.example.androiddevchallenge.ui

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

private enum class PuppyFinderScene {
    SPLASH_SCREEN, PUPPY_LIST_VIEWER
}

@Composable
fun Home() {
    var scene by remember { mutableStateOf(PuppyFinderScene.SPLASH_SCREEN) }
    Crossfade(
        targetState = scene,
        animationSpec = tween(durationMillis = 500, easing = FastOutLinearInEasing)
    ) { state ->
        when (state) {
            PuppyFinderScene.SPLASH_SCREEN -> SplashScreen(
                onLoad = { scene = PuppyFinderScene.PUPPY_LIST_VIEWER }
            )
            PuppyFinderScene.PUPPY_LIST_VIEWER -> PuppyListViewer()
        }
    }
}
