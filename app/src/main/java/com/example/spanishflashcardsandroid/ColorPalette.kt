package com.example.spanishflashcardsandroid

import androidx.compose.ui.graphics.Color

class ColorPalette {
    // https://developer.android.com/codelabs/jetpack-compose-theming#3

    public var primary = Color(0xFF825500)
    public var primaryContainer = Color(0xFFFFDDB3)
    public var onPrimaryContainer = Color(0xFF291800)
    public var secondary = Color(0xFF6F5B40)
    public var onSecondary = Color(0xFFFFFFFF)
    public var secondaryContainer = Color(0xFFFBDEBC)
    public var onSecondaryContainer = Color(0xFF271904)
    public var onPrimary = Color(0xFFFFFFFF)
    public var tertiary = Color(0xFF51643F)
    public var onTertiary = Color(0xFFFFFFFF)
    public var tertiaryContainer = Color(0xFFD4EABB)
    public var onTertiaryContainer = Color(0xFF102004)
    public var error = Color(0xFFBA1A1A)
    public var errorContainer = Color(0xFFFFDAD6)
    public var onError = Color(0xFFFFFFFF)
    public var onErrorContainer = Color(0xFF410002)
    public var background = Color(0xFFFFFBFF)
    public var onBackground = Color(0xFF1F1B16)
    public var surface = Color(0xFFFFFBFF)
    public var onSurface = Color(0xFF1F1B16)
    public var surfaceVariant = Color(0xFFF0E0CF)
    public var onSurfaceVariant = Color(0xFF4F4539)
    public var outline = Color(0xFF817567)
    public var inverseOnSurface = Color(0xFFF9EFE7)
    public var inverseSurface = Color(0xFF34302A)
    public var inversePrimary = Color(0xFFFFB951)
    public var shadow = Color(0xFF000000)
    public var surfaceTint = Color(0xFF825500)
    public var outlineVariant = Color(0xFFD3C4B4)
    public var scrim = Color(0xFF000000)
    public fun setDark() {
        primary = dark_primary
        primaryContainer = dark_primaryContainer
        onPrimaryContainer = dark_onPrimaryContainer
        secondary = dark_secondary
        onSecondary = dark_onSecondary
        secondaryContainer = dark_secondaryContainer
        onSecondaryContainer = dark_onSecondaryContainer
        onPrimary = dark_onPrimary
        tertiary = dark_tertiary
        onTertiary = dark_onTertiary
        tertiaryContainer = dark_tertiaryContainer
        onTertiaryContainer = dark_onTertiaryContainer
        error = dark_error
        errorContainer = dark_errorContainer
        onError = dark_onError
        onErrorContainer = dark_onErrorContainer
        background = dark_background
        onBackground = dark_onBackground
        surface = dark_surface
        onSurface = dark_onSurface
        surfaceVariant = dark_surfaceVariant
        onSurfaceVariant = dark_onSurfaceVariant
        outline = dark_outline
        inverseOnSurface = dark_inverseOnSurface
        inverseSurface = dark_inverseSurface
        inversePrimary = dark_inversePrimary
        shadow = dark_shadow
        surfaceTint = dark_surfaceTint
        outlineVariant = dark_outlineVariant
        scrim = dark_scrim
    }
    public fun setLight() {
        primary = light_primary
        primaryContainer = light_primaryContainer
        onPrimaryContainer = light_onPrimaryContainer
        secondary = light_secondary
        onSecondary = light_onSecondary
        secondaryContainer = light_secondaryContainer
        onSecondaryContainer = light_onSecondaryContainer
        onPrimary = light_onPrimary
        tertiary = light_tertiary
        onTertiary = light_onTertiary
        tertiaryContainer = light_tertiaryContainer
        onTertiaryContainer = light_onTertiaryContainer
        error = light_error
        errorContainer = light_errorContainer
        onError = light_onError
        onErrorContainer = light_onErrorContainer
        background = light_background
        onBackground = light_onBackground
        surface = light_surface
        onSurface = light_onSurface
        surfaceVariant = light_surfaceVariant
        onSurfaceVariant = light_onSurfaceVariant
        outline = light_outline
        inverseOnSurface = light_inverseOnSurface
        inverseSurface = light_inverseSurface
        inversePrimary = light_inversePrimary
        shadow = light_shadow
        surfaceTint = light_surfaceTint
        outlineVariant = light_outlineVariant
        scrim = light_scrim
    }

    private val light_primary = Color(0xFF825500)
    private val light_onPrimary = Color(0xFFFFFFFF)
    private val light_primaryContainer = Color(0xFFFFDDB3)
    private val light_onPrimaryContainer = Color(0xFF291800)
    private val light_secondary = Color(0xFF6F5B40)
    private val light_onSecondary = Color(0xFFFFFFFF)
    private val light_secondaryContainer = Color(0xFFFBDEBC)
    private val light_onSecondaryContainer = Color(0xFF271904)
    private val light_tertiary = Color(0xFF51643F)
    private val light_onTertiary = Color(0xFFFFFFFF)
    private val light_tertiaryContainer = Color(0xFFD4EABB)
    private val light_onTertiaryContainer = Color(0xFF102004)
    private val light_error = Color(0xFFBA1A1A)
    private val light_errorContainer = Color(0xFFFFDAD6)
    private val light_onError = Color(0xFFFFFFFF)
    private val light_onErrorContainer = Color(0xFF410002)
    private val light_background = Color(0xFFFFFBFF)
    private val light_onBackground = Color(0xFF1F1B16)
    private val light_surface = Color(0xFFFFFBFF)
    private val light_onSurface = Color(0xFF1F1B16)
    private val light_surfaceVariant = Color(0xFFF0E0CF)
    private val light_onSurfaceVariant = Color(0xFF4F4539)
    private val light_outline = Color(0xFF817567)
    private val light_inverseOnSurface = Color(0xFFF9EFE7)
    private val light_inverseSurface = Color(0xFF34302A)
    private val light_inversePrimary = Color(0xFFFFB951)
    private val light_shadow = Color(0xFF000000)
    private val light_surfaceTint = Color(0xFF825500)
    private val light_outlineVariant = Color(0xFFD3C4B4)
    private val light_scrim = Color(0xFF000000)

    private val dark_primary = Color(0xFFFFB951)
    private val dark_onPrimary = Color(0xFF452B00)
    private val dark_primaryContainer = Color(0xFF633F00)
    private val dark_onPrimaryContainer = Color(0xFFFFDDB3)
    private val dark_secondary = Color(0xFFDDC2A1)
    private val dark_onSecondary = Color(0xFF3E2D16)
    private val dark_secondaryContainer = Color(0xFF56442A)
    private val dark_onSecondaryContainer = Color(0xFFFBDEBC)
    private val dark_tertiary = Color(0xFFB8CEA1)
    private val dark_onTertiary = Color(0xFF243515)
    private val dark_tertiaryContainer = Color(0xFF3A4C2A)
    private val dark_onTertiaryContainer = Color(0xFFD4EABB)
    private val dark_error = Color(0xFFFFB4AB)
    private val dark_errorContainer = Color(0xFF93000A)
    private val dark_onError = Color(0xFF690005)
    private val dark_onErrorContainer = Color(0xFFFFDAD6)
    private val dark_background = Color(0xFF1F1B16)
    private val dark_onBackground = Color(0xFFEAE1D9)
    private val dark_surface = Color(0xFF1F1B16)
    private val dark_onSurface = Color(0xFFEAE1D9)
    private val dark_surfaceVariant = Color(0xFF4F4539)
    private val dark_onSurfaceVariant = Color(0xFFD3C4B4)
    private val dark_outline = Color(0xFF9C8F80)
    private val dark_inverseOnSurface = Color(0xFF1F1B16)
    private val dark_inverseSurface = Color(0xFFEAE1D9)
    private val dark_inversePrimary = Color(0xFF825500)
    private val dark_shadow = Color(0xFF000000)
    private val dark_surfaceTint = Color(0xFFFFB951)
    private val dark_outlineVariant = Color(0xFF4F4539)
    private val dark_scrim = Color(0xFF000000)


}