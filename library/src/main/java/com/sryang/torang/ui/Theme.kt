/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sryang.torang.ui

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.samples.apps.sunflower.ui.Shapes
import com.google.samples.apps.sunflower.ui.Typography
import com.google.samples.apps.sunflower.ui.md_theme_dark_background
import com.google.samples.apps.sunflower.ui.md_theme_dark_error
import com.google.samples.apps.sunflower.ui.md_theme_dark_errorContainer
import com.google.samples.apps.sunflower.ui.md_theme_dark_inverseOnSurface
import com.google.samples.apps.sunflower.ui.md_theme_dark_inversePrimary
import com.google.samples.apps.sunflower.ui.md_theme_dark_inverseSurface
import com.google.samples.apps.sunflower.ui.md_theme_dark_onBackground
import com.google.samples.apps.sunflower.ui.md_theme_dark_onError
import com.google.samples.apps.sunflower.ui.md_theme_dark_onErrorContainer
import com.google.samples.apps.sunflower.ui.md_theme_dark_onPrimary
import com.google.samples.apps.sunflower.ui.md_theme_dark_onPrimaryContainer
import com.google.samples.apps.sunflower.ui.md_theme_dark_onSecondary
import com.google.samples.apps.sunflower.ui.md_theme_dark_onSecondaryContainer
import com.google.samples.apps.sunflower.ui.md_theme_dark_onSurface
import com.google.samples.apps.sunflower.ui.md_theme_dark_onSurfaceVariant
import com.google.samples.apps.sunflower.ui.md_theme_dark_onTertiary
import com.google.samples.apps.sunflower.ui.md_theme_dark_onTertiaryContainer
import com.google.samples.apps.sunflower.ui.md_theme_dark_outline
import com.google.samples.apps.sunflower.ui.md_theme_dark_outlineVariant
import com.google.samples.apps.sunflower.ui.md_theme_dark_primary
import com.google.samples.apps.sunflower.ui.md_theme_dark_primaryContainer
import com.google.samples.apps.sunflower.ui.md_theme_dark_scrim
import com.google.samples.apps.sunflower.ui.md_theme_dark_secondary
import com.google.samples.apps.sunflower.ui.md_theme_dark_secondaryContainer
import com.google.samples.apps.sunflower.ui.md_theme_dark_surface
import com.google.samples.apps.sunflower.ui.md_theme_dark_surfaceTint
import com.google.samples.apps.sunflower.ui.md_theme_dark_surfaceVariant
import com.google.samples.apps.sunflower.ui.md_theme_dark_tertiary
import com.google.samples.apps.sunflower.ui.md_theme_dark_tertiaryContainer
import com.google.samples.apps.sunflower.ui.md_theme_light_background
import com.google.samples.apps.sunflower.ui.md_theme_light_error
import com.google.samples.apps.sunflower.ui.md_theme_light_errorContainer
import com.google.samples.apps.sunflower.ui.md_theme_light_inverseOnSurface
import com.google.samples.apps.sunflower.ui.md_theme_light_inversePrimary
import com.google.samples.apps.sunflower.ui.md_theme_light_inverseSurface
import com.google.samples.apps.sunflower.ui.md_theme_light_onBackground
import com.google.samples.apps.sunflower.ui.md_theme_light_onError
import com.google.samples.apps.sunflower.ui.md_theme_light_onErrorContainer
import com.google.samples.apps.sunflower.ui.md_theme_light_onPrimary
import com.google.samples.apps.sunflower.ui.md_theme_light_onPrimaryContainer
import com.google.samples.apps.sunflower.ui.md_theme_light_onSecondary
import com.google.samples.apps.sunflower.ui.md_theme_light_onSecondaryContainer
import com.google.samples.apps.sunflower.ui.md_theme_light_onSurface
import com.google.samples.apps.sunflower.ui.md_theme_light_onSurfaceVariant
import com.google.samples.apps.sunflower.ui.md_theme_light_onTertiary
import com.google.samples.apps.sunflower.ui.md_theme_light_onTertiaryContainer
import com.google.samples.apps.sunflower.ui.md_theme_light_outline
import com.google.samples.apps.sunflower.ui.md_theme_light_outlineVariant
import com.google.samples.apps.sunflower.ui.md_theme_light_primary
import com.google.samples.apps.sunflower.ui.md_theme_light_primaryContainer
import com.google.samples.apps.sunflower.ui.md_theme_light_scrim
import com.google.samples.apps.sunflower.ui.md_theme_light_secondary
import com.google.samples.apps.sunflower.ui.md_theme_light_secondaryContainer
import com.google.samples.apps.sunflower.ui.md_theme_light_surface
import com.google.samples.apps.sunflower.ui.md_theme_light_surfaceTint
import com.google.samples.apps.sunflower.ui.md_theme_light_surfaceVariant
import com.google.samples.apps.sunflower.ui.md_theme_light_tertiary
import com.google.samples.apps.sunflower.ui.md_theme_light_tertiaryContainer

private val LightColors = lightColorScheme(
    primary = md_theme_light_primary,
    onPrimary = md_theme_light_onPrimary,
    primaryContainer = md_theme_light_primaryContainer,
    onPrimaryContainer = md_theme_light_onPrimaryContainer,
    secondary = md_theme_light_secondary,
    onSecondary = md_theme_light_onSecondary,
    secondaryContainer = md_theme_light_secondaryContainer,
    onSecondaryContainer = md_theme_light_onSecondaryContainer,
    tertiary = md_theme_light_tertiary,
    onTertiary = md_theme_light_onTertiary,
    tertiaryContainer = md_theme_light_tertiaryContainer,
    onTertiaryContainer = md_theme_light_onTertiaryContainer,
    error = md_theme_light_error,
    errorContainer = md_theme_light_errorContainer,
    onError = md_theme_light_onError,
    onErrorContainer = md_theme_light_onErrorContainer,
    background = md_theme_light_background,
    onBackground = md_theme_light_onBackground,
    surface = md_theme_light_surface,
    onSurface = md_theme_light_onSurface,
    surfaceVariant = md_theme_light_surfaceVariant,
    onSurfaceVariant = md_theme_light_onSurfaceVariant,
    outline = md_theme_light_outline,
    inverseOnSurface = md_theme_light_inverseOnSurface,
    inverseSurface = md_theme_light_inverseSurface,
    inversePrimary = md_theme_light_inversePrimary,
    surfaceTint = md_theme_light_surfaceTint,
    outlineVariant = md_theme_light_outlineVariant,
    scrim = md_theme_light_scrim,
)


private val DarkColors = darkColorScheme(
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    primaryContainer = md_theme_dark_primaryContainer,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer,
    secondary = md_theme_dark_secondary,
    onSecondary = md_theme_dark_onSecondary,
    secondaryContainer = md_theme_dark_secondaryContainer,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer,
    tertiary = md_theme_dark_tertiary,
    onTertiary = md_theme_dark_onTertiary,
    tertiaryContainer = md_theme_dark_tertiaryContainer,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer,
    error = md_theme_dark_error,
    errorContainer = md_theme_dark_errorContainer,
    onError = md_theme_dark_onError,
    onErrorContainer = md_theme_dark_onErrorContainer,
    background = md_theme_dark_background,
    onBackground = md_theme_dark_onBackground,
    surface = md_theme_dark_surface,
    onSurface = md_theme_dark_onSurface,
    surfaceVariant = md_theme_dark_surfaceVariant,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant,
    outline = md_theme_dark_outline,
    inverseOnSurface = md_theme_dark_inverseOnSurface,
    inverseSurface = md_theme_dark_inverseSurface,
    inversePrimary = md_theme_dark_inversePrimary,
    surfaceTint = md_theme_dark_surfaceTint,
    outlineVariant = md_theme_dark_outlineVariant,
    scrim = md_theme_dark_scrim,
)

@Composable
fun TorangTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColors
        else -> LightColors
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        val systemUiController = rememberSystemUiController()
        val useDarkIcons = !isSystemInDarkTheme()
        DisposableEffect(systemUiController, useDarkIcons) {
            // Update all of the system bar colors to be transparent, and use
            // dark icons if we're in light theme
            systemUiController.setSystemBarsColor(
                color = Color.Transparent,
                darkIcons = useDarkIcons
            )
            onDispose {}
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        shapes = Shapes,
        typography = Typography,
        content = content
    )
}