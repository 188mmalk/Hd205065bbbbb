package com.example.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Wallpaper
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.R
import com.example.data.AppThemePreset
import com.example.ui.theme.LocalAppTheme
import com.example.ui.theme.parseHexColor
import com.example.ui.viewmodel.InvoiceViewModel

@Composable
fun AppThemeCustomizerModal(
  viewModel: InvoiceViewModel,
  onDismiss: () -> Unit
) {
  val uiState by viewModel.uiState.collectAsState()
  val appTheme = LocalAppTheme.current
  val config = uiState.uiCustomizationConfig
  val currentPresetId = config.themePresetId

  Dialog(
    onDismissRequest = onDismiss,
    properties = DialogProperties(usePlatformDefaultWidth = false)
  ) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
      Card(
        modifier = Modifier
          .fillMaxWidth(0.95f)
          .fillMaxHeight(0.88f),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
        border = BorderStroke(1.5.dp, appTheme.primary.copy(alpha = 0.5f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp)
      ) {
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
        ) {
          // Header
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Row(
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
              Box(
                modifier = Modifier
                  .size(36.dp)
                  .clip(CircleShape)
                  .background(appTheme.primary.copy(alpha = 0.2f)),
                contentAlignment = Alignment.Center
              ) {
                Icon(
                  imageVector = Icons.Default.Palette,
                  contentDescription = null,
                  tint = appTheme.primary,
                  modifier = Modifier.size(20.dp)
                )
              }
              Column {
                Text(
                  text = "تخصيص ثيم ومظهر التطبيق",
                  fontSize = 17.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White
                )
                Text(
                  text = "اختر الثيم المفضل وسيتغير مظهر التطبيق فوراً",
                  fontSize = 11.5.sp,
                  color = Color(0xFF94A3B8)
                )
              }
            }
            IconButton(onClick = onDismiss) {
              Icon(Icons.Default.Close, contentDescription = "إغلاق", tint = Color.White)
            }
          }

          Spacer(modifier = Modifier.height(10.dp))

          // List of Presets
          LazyColumn(
            modifier = Modifier
              .fillMaxWidth()
              .weight(1f),
            verticalArrangement = Arrangement.spacedBy(10.dp)
          ) {
            items(AppThemePreset.entries) { preset ->
              val isSelected = currentPresetId == preset.id
              val primaryColor = parseHexColor(preset.primaryHex)
              val secondaryColor = parseHexColor(preset.secondaryHex)

              Card(
                onClick = { viewModel.setAppThemePreset(preset) },
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(
                  containerColor = if (isSelected) primaryColor.copy(alpha = 0.18f) else Color(0xFF1E293B)
                ),
                border = BorderStroke(
                  width = if (isSelected) 2.dp else 1.dp,
                  color = if (isSelected) primaryColor else Color(0xFF334155)
                ),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(12.dp)) {
                  Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                  ) {
                    Row(
                      verticalAlignment = Alignment.CenterVertically,
                      horizontalArrangement = Arrangement.spacedBy(10.dp),
                      modifier = Modifier.weight(1f)
                    ) {
                      Box(
                        modifier = Modifier
                          .size(42.dp)
                          .clip(CircleShape)
                          .background(
                            Brush.linearGradient(
                              listOf(primaryColor.copy(alpha = 0.35f), secondaryColor.copy(alpha = 0.35f))
                            )
                          ),
                        contentAlignment = Alignment.Center
                      ) {
                        Text(text = preset.emoji, fontSize = 22.sp)
                      }
                      Column {
                        Row(
                          verticalAlignment = Alignment.CenterVertically,
                          horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                          Text(
                            text = preset.titleAr,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp,
                            color = Color.White
                          )
                          if (preset == AppThemePreset.OCEAN_AZURE_GOLD) {
                            Surface(
                              shape = RoundedCornerShape(4.dp),
                              color = Color(0xFF0284C7).copy(alpha = 0.25f),
                              border = BorderStroke(1.dp, Color(0xFF38BDF8))
                            ) {
                              Text(
                                text = "مستوحى من صورتك 📸",
                                color = Color(0xFF7DD3FC),
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                              )
                            }
                          }
                        }
                        Text(
                          text = preset.descAr,
                          fontSize = 11.5.sp,
                          color = Color(0xFF94A3B8)
                        )
                      }
                    }

                    Row(
                      verticalAlignment = Alignment.CenterVertically,
                      horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                      Box(
                        modifier = Modifier
                          .size(22.dp)
                          .clip(CircleShape)
                          .background(primaryColor)
                          .border(1.dp, Color.White.copy(alpha = 0.4f), CircleShape)
                      )
                      Box(
                        modifier = Modifier
                          .size(22.dp)
                          .clip(CircleShape)
                          .background(secondaryColor)
                          .border(1.dp, Color.White.copy(alpha = 0.4f), CircleShape)
                      )
                      if (isSelected) {
                        Box(
                          modifier = Modifier
                            .size(22.dp)
                            .clip(CircleShape)
                            .background(primaryColor),
                          contentAlignment = Alignment.Center
                        ) {
                          Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "محدد",
                            tint = Color.White,
                            modifier = Modifier.size(15.dp)
                          )
                        }
                      }
                    }
                  }

                  // Optional Ocean Wallpaper section when OCEAN_AZURE_GOLD is selected or viewed
                  if (preset == AppThemePreset.OCEAN_AZURE_GOLD && isSelected) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Surface(
                      shape = RoundedCornerShape(10.dp),
                      color = Color(0xFF0B213F),
                      border = BorderStroke(1.dp, Color(0xFF0284C7).copy(alpha = 0.4f)),
                      modifier = Modifier.fillMaxWidth()
                    ) {
                      Column(modifier = Modifier.padding(10.dp)) {
                        Row(
                          modifier = Modifier.fillMaxWidth(),
                          verticalAlignment = Alignment.CenterVertically,
                          horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                          Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                          ) {
                            Icon(
                              imageVector = Icons.Default.Wallpaper,
                              contentDescription = null,
                              tint = Color(0xFF38BDF8),
                              modifier = Modifier.size(18.dp)
                            )
                            Column {
                              Text(
                                text = "خلفية صورة المحيط الجوية (اختياري)",
                                fontSize = 12.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                              )
                              Text(
                                text = "عرض صورة الشاطئ والرمال الذهبية في خلفية الواجهة",
                                fontSize = 10.5.sp,
                                color = Color(0xFF7DD3FC)
                              )
                            }
                          }
                          Switch(
                            checked = config.useOceanWallpaper,
                            onCheckedChange = { viewModel.toggleOceanWallpaper(it) },
                            colors = SwitchDefaults.colors(
                              checkedThumbColor = Color(0xFF38BDF8),
                              checkedTrackColor = Color(0xFF0284C7)
                            )
                          )
                        }

                        if (config.useOceanWallpaper) {
                          Spacer(modifier = Modifier.height(8.dp))
                          // Miniature wallpaper preview
                          Box(
                            modifier = Modifier
                              .fillMaxWidth()
                              .height(72.dp)
                              .clip(RoundedCornerShape(8.dp))
                              .border(1.dp, Color(0xFF0284C7), RoundedCornerShape(8.dp))
                          ) {
                            Image(
                              painter = painterResource(id = R.drawable.ocean_theme_bg_1791124990380),
                              contentDescription = "معاينة صورة المحيط",
                              contentScale = ContentScale.Crop,
                              modifier = Modifier.fillMaxSize()
                            )
                            Box(
                              modifier = Modifier
                                .fillMaxSize()
                                .background(
                                  Brush.verticalGradient(
                                    listOf(
                                      Color.Transparent,
                                      Color(0xCC041226)
                                    )
                                  )
                                )
                                .padding(6.dp),
                              contentAlignment = Alignment.BottomStart
                            ) {
                              Text(
                                text = "🏝️ جزيرة الرمال والمياه الفيروزية",
                                color = Color(0xFFFDE68A),
                                fontSize = 10.5.sp,
                                fontWeight = FontWeight.Bold
                              )
                            }
                          }

                          Spacer(modifier = Modifier.height(8.dp))
                          Text(
                            text = "درجة وضوح وشفافية الصورة:",
                            fontSize = 11.sp,
                            color = Color(0xFFE2E8F0)
                          )
                          Row(
                            modifier = Modifier
                              .fillMaxWidth()
                              .padding(top = 4.dp),
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                          ) {
                            listOf(
                              0.20f to "خفيفة (20%)",
                              0.35f to "متوازنة (35%)",
                              0.55f to "واضحة (55%)"
                            ).forEach { (alphaVal, label) ->
                              val isAlphaSelected = kotlin.math.abs(config.oceanWallpaperAlpha - alphaVal) < 0.08f
                              FilterChip(
                                selected = isAlphaSelected,
                                onClick = { viewModel.setOceanWallpaperAlpha(alphaVal) },
                                label = { Text(label, fontSize = 10.sp) },
                                colors = FilterChipDefaults.filterChipColors(
                                  selectedContainerColor = Color(0xFF0284C7),
                                  selectedLabelColor = Color.White
                                )
                              )
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }

          Spacer(modifier = Modifier.height(12.dp))

          // Bottom Buttons
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            OutlinedButton(
              onClick = { viewModel.resetAppThemeToDefault() },
              shape = RoundedCornerShape(10.dp),
              border = BorderStroke(1.dp, Color(0xFF64748B)),
              modifier = Modifier.weight(1f)
            ) {
              Icon(Icons.Default.Refresh, contentDescription = null, tint = Color(0xFF94A3B8), modifier = Modifier.size(16.dp))
              Spacer(modifier = Modifier.size(4.dp))
              Text("استعادة الافتراضي", fontSize = 12.sp, color = Color(0xFFE2E8F0))
            }
            Button(
              onClick = onDismiss,
              shape = RoundedCornerShape(10.dp),
              colors = ButtonDefaults.buttonColors(containerColor = appTheme.primary),
              modifier = Modifier.weight(1f)
            ) {
              Text("تم وتطبيق", fontSize = 13.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
          }
        }
      }
    }
  }
}

