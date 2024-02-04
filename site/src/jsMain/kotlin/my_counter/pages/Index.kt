package my_counter.pages

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxHeight
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.minWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import my_counter.components.GooglePlayLogo
import my_counter.ui.Theme
import my_counter.util.Constants
import my_counter.util.Res
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh

@Page
@Composable
fun MainPage() {
    val breakpoint = rememberBreakpoint()
    if (breakpoint > Breakpoint.SM) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
                Header()
                Body()
                Footer()
        }
    } else {
        Box(
            modifier = Modifier.height(100.vh),
            contentAlignment = Alignment.BottomCenter,
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                MobileHeader()
                MobileBody()
            }
            MobileFooter()
        }
    }
}

@Composable
fun Header() {
    Box {
        Image(
            modifier = Modifier.fillMaxSize(),
            src = Res.Image.Banner,
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .maxWidth(1280.px)
                .maxHeight(624.px),
            contentAlignment = Alignment.BottomStart,
        ) {
            Box(
                modifier = Modifier
                    .width(26.percent)
                    .height(16.percent)
                    .margin(left = 8.percent, bottom = 4.percent),
                contentAlignment = Alignment.Center,
            ) {
                GooglePlayLogo()
            }
        }
    }
}

@Composable
fun Body() {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(leftRight = 16.px)
    ) {
        Introduction()
    }
}

@Composable
fun Introduction() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(64.px)
    ) {
        IntroductionCard(
            title = Constants.WordCardTitle,
            description = Constants.WordCardDesc,
            imageRes = Res.Image.WordCard,
        )
        IntroductionCard(
            title = Constants.TrainStudyTitle,
            description = Constants.TrainStudyDesc,
            imageRes = Res.Image.TrainStudy,
        )
        IntroductionCard(
            title = Constants.FreeAppTitle,
            description = Constants.FreeAppDesc,
            imageRes = Res.Image.FreeApp,
        )
    }
}

@Composable
fun IntroductionCard(
    title: String,
    description: String,
    imageRes: String,
) {
    val descriptions = description.split("\n")
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(40.px),
        horizontalArrangement = Arrangement.Center,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .maxWidth(640.px)
                .padding(right = 40.px)
        ) {
            SpanText(
                text = title,
                modifier = Modifier
                    .fontSize(24.px)
                    .fontWeight(FontWeight.Bold)
                    .padding(bottom = 16.px)
            )
            descriptions.forEach { desc ->
                SpanText(
                    text = desc.ifEmpty { " " },
                    modifier = Modifier.fontSize(18.px)
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .minWidth(320.px),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                src = imageRes
            )
        }
    }
}

@Composable
fun Footer() {
    SpanText(text = Constants.PlayLegalAttribution)
}

@Composable
fun MobileHeader() {
    Box {
        Image(
            modifier = Modifier.fillMaxSize(),
            src = Res.Image.MobileBanner,
        )
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomEnd,
        ) {
            Box(
                modifier = Modifier
                    .width(40.percent)
                    .margin(right = 8.percent, bottom = 32.percent),
                contentAlignment = Alignment.Center,
            ) {
                GooglePlayLogo()
            }
        }
    }
}

@Composable
fun MobileBody() {
    Column(
        modifier = Modifier.fillMaxSize()
            .maxWidth(560.px)
            .padding(leftRight = 16.px),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        MobileIntroduction()
    }
}

@Composable
fun MobileIntroduction() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.px)
    ) {
        MobileIntroductionCard(
            title = Constants.WordCardTitle,
            description = Constants.WordCardDesc,
            imageRes = Res.Image.WordCard,
        )
        MobileIntroductionCard(
            title = Constants.TrainStudyTitle,
            description = Constants.TrainStudyDesc,
            imageRes = Res.Image.TrainStudy,
        )
        MobileIntroductionCard(
            title = Constants.FreeAppTitle,
            description = Constants.FreeAppDesc,
            imageRes = Res.Image.FreeApp,
        )
    }
}

@Composable
fun MobileIntroductionCard(
    title: String,
    description: String,
    imageRes: String,
) {
    val descriptions = description.split("\n")
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 48.px)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.px),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                src = imageRes
            )
        }
        SpanText(
            text = title,
            modifier = Modifier
                .fillMaxWidth()
                .fontSize(16.px)
                .fontWeight(FontWeight.Bold)
                .padding(bottom = 8.px)
                .textAlign(TextAlign.Center),
        )
        descriptions.forEach { desc ->
            SpanText(
                text = desc.ifEmpty { " " },
                modifier = Modifier.fontSize(if (desc.isEmpty()) 6.px else 14.px)
            )
        }
    }
}
@Composable
fun MobileFooter() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .backgroundColor(Theme.Main.rgb)
            .position(Position.Fixed)
            .height(64.px),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        GooglePlayLogo(
            modifier = Modifier
                .width(144.px)
                .height(48.px)
                .padding(right = 24.px)
        )
        SpanText(
            modifier = Modifier
                .width(144.px)
                .fontSize(8.px)
                .color(Colors.White),
            text = Constants.PlayLegalAttribution
        )
    }
}
