package my_counter.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.navigation.Anchor
import com.varabyte.kobweb.silk.components.graphics.Image
import my_counter.util.Url

@Composable
fun GooglePlayLogo(
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        Anchor(
            href = Url.DownloadPage,
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                alt = "Google Play で手に入れよう",
                src = Url.GooglePlayImage,
            )
        }
    }
}