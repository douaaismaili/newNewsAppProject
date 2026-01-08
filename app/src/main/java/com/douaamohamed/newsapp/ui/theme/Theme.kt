package com.douaamohamed.newsapp.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.compose.material3.Typography as Material3Typography

private val RedBlackColorScheme = darkColorScheme(
    primary = RedPrimary,
    onPrimary = WhiteText,
    primaryContainer = RedPrimaryDark,
    secondary = RedAccent,
    onSecondary = WhiteText,
    background = BlackBackground,
    onBackground = WhiteText,
    surface = DarkSurface,
    onSurface = WhiteText,
    error = ErrorRed,
    onError = WhiteText
)

@Composable
fun NewsAppTheme(
    darkTheme: Boolean = true,  // On force le dark mode pour un look rouge/noir intense
    dynamicColor: Boolean = false,  // On désactive complètement le dynamic color (source du violet !)
    content: @Composable () -> Unit
) {
    val colorScheme = RedBlackColorScheme  // On utilise toujours notre thème personnalisé

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as? Activity)?.window
            window?.statusBarColor = colorScheme.primary.toArgb()
            window?.let {
                WindowCompat.getInsetsController(it, view).isAppearanceLightStatusBars = false
            }
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Material3Typography(),
        content = content
    )
}