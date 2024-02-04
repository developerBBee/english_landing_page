package my_counter.ui

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgb

enum class Theme(
    val hex: String,
    val rgb: CSSColorValue,
) {
    Main(
        hex = "#FF684D",
        rgb = rgb(255,104,77)
    ),
}