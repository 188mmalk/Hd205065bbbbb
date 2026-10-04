package com.example.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.example.data.AppThemePreset
import com.example.data.UiCustomizationConfig

val LocalShadedFieldColor = compositionLocalOf { Color(0xFFFFF0F3) }
val LocalShadedFieldBorder = compositionLocalOf { Color(0xFFFDA4AF) }

data class AppThemeColors(
  val preset: AppThemePreset,
  val primary: Color,
  val secondary: Color,
  val accentColor: Color,
  val backgroundGradient: List<Color>,
  val cardColor: Color,
  val cardBorder: Color,
  val textPrimary: Color,
  val textSecondary: Color,
  val headerAccentBrush: List<Color>,
  val isDark: Boolean,
  val useOceanWallpaper: Boolean,
  val oceanWallpaperAlpha: Float
)

fun resolveAppTheme(config: UiCustomizationConfig): AppThemeColors {
  val preset = config.currentTheme()
  val useOcean = (preset == AppThemePreset.OCEAN_AZURE_GOLD && config.useOceanWallpaper) || config.useOceanWallpaper
  val oceanAlpha = config.oceanWallpaperAlpha.coerceIn(0.1f, 0.95f)

  return when (preset) {
    AppThemePreset.ROYAL_PURPLE -> AppThemeColors(
      preset = preset,
      primary = Color(0xFF7C3AED),
      secondary = Color(0xFF8B5CF6),
      accentColor = Color(0xFFEAB308),
      backgroundGradient = listOf(Color(0xFF280F43), Color(0xFF1B0730), Color(0xFF10031E)),
      cardColor = Color(0xFF25103E),
      cardBorder = Color(0xFF7C3AED),
      textPrimary = Color(0xFFF5F3FF),
      textSecondary = Color(0xFFDDD6FE),
      headerAccentBrush = listOf(Color(0xFF00F2FE), Color(0xFF8B5CF6), Color(0xFFEC4899), Color(0xFFEAB308)),
      isDark = true,
      useOceanWallpaper = useOcean,
      oceanWallpaperAlpha = oceanAlpha
    )
    AppThemePreset.OCEAN_AZURE_GOLD -> AppThemeColors(
      preset = preset,
      primary = Color(0xFF0284C7),
      secondary = Color(0xFF0EA5E9),
      accentColor = Color(0xFFF59E0B),
      backgroundGradient = listOf(Color(0xFF082747), Color(0xFF051B33), Color(0xFF020D1A)),
      cardColor = Color(0xFF0A2E54),
      cardBorder = Color(0xFF0284C7),
      textPrimary = Color(0xFFF0F9FF),
      textSecondary = Color(0xFFBAE6FD),
      headerAccentBrush = listOf(Color(0xFF38BDF8), Color(0xFF0284C7), Color(0xFFF59E0B), Color(0xFFFDE68A)),
      isDark = true,
      useOceanWallpaper = useOcean,
      oceanWallpaperAlpha = oceanAlpha
    )
    AppThemePreset.MODERN_NAVY -> AppThemeColors(
      preset = preset,
      primary = Color(0xFF0284C7),
      secondary = Color(0xFF0369A1),
      accentColor = Color(0xFF38BDF8),
      backgroundGradient = listOf(Color(0xFF111E36), Color(0xFF0B1425), Color(0xFF060B14)),
      cardColor = Color(0xFF162542),
      cardBorder = Color(0xFF0284C7),
      textPrimary = Color(0xFFF8FAFC),
      textSecondary = Color(0xFFCBD5E1),
      headerAccentBrush = listOf(Color(0xFF38BDF8), Color(0xFF60A5FA), Color(0xFF818CF8)),
      isDark = true,
      useOceanWallpaper = useOcean,
      oceanWallpaperAlpha = oceanAlpha
    )
    AppThemePreset.EMERALD_PRO -> AppThemeColors(
      preset = preset,
      primary = Color(0xFF059669),
      secondary = Color(0xFF10B981),
      accentColor = Color(0xFF34D399),
      backgroundGradient = listOf(Color(0xFF08382B), Color(0xFF04261C), Color(0xFF021610)),
      cardColor = Color(0xFF0A4434),
      cardBorder = Color(0xFF10B981),
      textPrimary = Color(0xFFF0FDF4),
      textSecondary = Color(0xFFA7F3D0),
      headerAccentBrush = listOf(Color(0xFF34D399), Color(0xFF10B981), Color(0xFF6EE7B7)),
      isDark = true,
      useOceanWallpaper = useOcean,
      oceanWallpaperAlpha = oceanAlpha
    )
    AppThemePreset.DARK_LUXURY -> AppThemeColors(
      preset = preset,
      primary = Color(0xFFF59E0B),
      secondary = Color(0xFFD97706),
      accentColor = Color(0xFFFBBF24),
      backgroundGradient = listOf(Color(0xFF1C1C20), Color(0xFF121215), Color(0xFF08080A)),
      cardColor = Color(0xFF232328),
      cardBorder = Color(0xFFF59E0B),
      textPrimary = Color(0xFFFAFAFA),
      textSecondary = Color(0xFFD4D4D8),
      headerAccentBrush = listOf(Color(0xFFF59E0B), Color(0xFFD97706), Color(0xFFFDE68A)),
      isDark = true,
      useOceanWallpaper = useOcean,
      oceanWallpaperAlpha = oceanAlpha
    )
    AppThemePreset.IMPERIAL_RUBY -> AppThemeColors(
      preset = preset,
      primary = Color(0xFFE11D48),
      secondary = Color(0xFFBE123C),
      accentColor = Color(0xFFFB7185),
      backgroundGradient = listOf(Color(0xFF4C0E1E), Color(0xFF330713), Color(0xFF1E030B)),
      cardColor = Color(0xFF561123),
      cardBorder = Color(0xFFE11D48),
      textPrimary = Color(0xFFFFF1F2),
      textSecondary = Color(0xFFFECDD3),
      headerAccentBrush = listOf(Color(0xFFFB7185), Color(0xFFE11D48), Color(0xFFFDA4AF)),
      isDark = true,
      useOceanWallpaper = useOcean,
      oceanWallpaperAlpha = oceanAlpha
    )
    AppThemePreset.CYBER_TITANIUM -> AppThemeColors(
      preset = preset,
      primary = Color(0xFF06B6D4),
      secondary = Color(0xFF0891B2),
      accentColor = Color(0xFF22D3EE),
      backgroundGradient = listOf(Color(0xFF334155), Color(0xFF1E293B), Color(0xFF0F172A)),
      cardColor = Color(0xFF28364A),
      cardBorder = Color(0xFF06B6D4),
      textPrimary = Color(0xFFF8FAFC),
      textSecondary = Color(0xFFCBD5E1),
      headerAccentBrush = listOf(Color(0xFF22D3EE), Color(0xFF06B6D4), Color(0xFF38BDF8)),
      isDark = true,
      useOceanWallpaper = useOcean,
      oceanWallpaperAlpha = oceanAlpha
    )
    AppThemePreset.SUNSET_GOLD -> AppThemeColors(
      preset = preset,
      primary = Color(0xFFEA580C),
      secondary = Color(0xFFF97316),
      accentColor = Color(0xFFFBBF24),
      backgroundGradient = listOf(Color(0xFF521C07), Color(0xFF381203), Color(0xFF210901)),
      cardColor = Color(0xFF5C2009),
      cardBorder = Color(0xFFF97316),
      textPrimary = Color(0xFFFFF7ED),
      textSecondary = Color(0xFFFED7AA),
      headerAccentBrush = listOf(Color(0xFFFBBF24), Color(0xFFF97316), Color(0xFFFB923C)),
      isDark = true,
      useOceanWallpaper = useOcean,
      oceanWallpaperAlpha = oceanAlpha
    )
    AppThemePreset.SOFT_LAVENDER -> AppThemeColors(
      preset = preset,
      primary = Color(0xFF9333EA),
      secondary = Color(0xFFA855F7),
      accentColor = Color(0xFFF472B6),
      backgroundGradient = listOf(Color(0xFF3E1F59), Color(0xFF2A123E), Color(0xFF1A0A28)),
      cardColor = Color(0xFF452264),
      cardBorder = Color(0xFFA855F7),
      textPrimary = Color(0xFFFAF5FF),
      textSecondary = Color(0xFFE9D5FF),
      headerAccentBrush = listOf(Color(0xFFF472B6), Color(0xFFA855F7), Color(0xFFE879F9)),
      isDark = true,
      useOceanWallpaper = useOcean,
      oceanWallpaperAlpha = oceanAlpha
    )
    AppThemePreset.CUSTOM -> {
      val prim = parseHexColor(config.customPrimaryColorHex, Color(0xFF7C3AED))
      val sec = parseHexColor(config.customSecondaryColorHex, Color(0xFF8B5CF6))
      val bg = parseHexColor(config.customBgColorHex, Color(0xFF1D0B36))
      val card = parseHexColor(config.customCardColorHex, Color(0xFF281245))
      AppThemeColors(
        preset = preset,
        primary = prim,
        secondary = sec,
        accentColor = sec,
        backgroundGradient = listOf(bg, bg.copy(alpha = 0.85f), Color(0xFF090312)),
        cardColor = card,
        cardBorder = prim,
        textPrimary = Color.White,
        textSecondary = Color(0xFFE2E8F0),
        headerAccentBrush = listOf(prim, sec, prim),
        isDark = true,
        useOceanWallpaper = useOcean,
        oceanWallpaperAlpha = oceanAlpha
      )
    }
  }
}

val LocalAppTheme = compositionLocalOf { resolveAppTheme(UiCustomizationConfig()) }

@Composable
fun MyApplicationTheme(
  themeConfig: UiCustomizationConfig = UiCustomizationConfig(),
  darkTheme: Boolean = false,
  dynamicColor: Boolean = false,
  content: @Composable () -> Unit,
) {
  val appTheme = remember(themeConfig) { resolveAppTheme(themeConfig) }
  val colorScheme = remember(appTheme) {
    darkColorScheme(
      primary = appTheme.primary,
      secondary = appTheme.secondary,
      tertiary = appTheme.accentColor,
      background = appTheme.backgroundGradient.first(),
      surface = appTheme.cardColor,
      onPrimary = Color.White,
      onSecondary = Color.White,
      onTertiary = Color.Black,
      onBackground = appTheme.textPrimary,
      onSurface = appTheme.textPrimary,
      outline = appTheme.cardBorder
    )
  }

  CompositionLocalProvider(
    LocalAppTheme provides appTheme
  ) {
    MaterialTheme(colorScheme = colorScheme, typography = Typography, content = content)
  }
}
