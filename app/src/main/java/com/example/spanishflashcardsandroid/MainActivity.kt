package com.example.spanishflashcardsandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spanishflashcardsandroid.ui.theme.SpanishFlashCardsAndroidTheme

val palette = ColorPalette()


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        palette.setDark()
        super.onCreate(savedInstanceState)
        setContent {
            SpanishFlashCardsAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = palette.background,

                ) {
                    MainWindow()
                }
            }
        }
    }
}
@Composable
fun MainWindow(modifier: Modifier = Modifier) {
    Column (verticalArrangement = Arrangement.SpaceEvenly) {

        Text(
            text = "Tarjetas Didácticas en Español",
            fontSize = 35.sp,
            style = TextStyle(lineHeight = 35.sp),
            textAlign = TextAlign.Center,
            color = palette.onBackground,
        )
        Text(
            text = "Streak: 2",
            fontSize = 15.sp,
            textAlign = TextAlign.End,
            color = palette.onBackground,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 7.dp)
        )

        ActionButtonRow(modifier = modifier)
        TranslationCard(
            typeFront = "Adverb",
            typeBack = "Adverbio",
            wordFront = "how?",
            wordBack = "¿cómo…?",
            sentenceFront = "How do you know my name?",
            sentenceBack = "¿Cómo sabes mi nombre?",
            modifier = Modifier.fillMaxHeight()
        )
        NavButtonRow(modifier = modifier)
    }

}
@Composable
fun TranslationCard(
    typeFront:String, typeBack:String,
    wordFront:String, wordBack:String,
    sentenceFront:String, sentenceBack:String,
    modifier: Modifier = Modifier) {


    Box (
        modifier = Modifier
            .background(color = palette.primaryContainer)
            .padding(vertical = 25.dp)
    ) {
        Column(verticalArrangement = Arrangement.SpaceAround) {
            Text(
                text = typeFront,
                fontSize = 15.sp,
                textAlign = TextAlign.End,
                color = palette.onSecondaryContainer,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 7.dp)
            )
            Text(
                text = wordFront,
                fontSize = 35.sp,
                textAlign = TextAlign.Center,
                color = palette.onPrimaryContainer,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
            Text(
                text = sentenceFront,
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                color = palette.onPrimaryContainer,
                style = TextStyle(lineHeight = 18.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
        }
    }

    Box (
        modifier = Modifier
            .background(color = palette.secondary)
            .padding(vertical = 25.dp)
    ) {
    Column(verticalArrangement = Arrangement.SpaceAround) {
            Text(
                text = typeBack,
                fontSize = 12.sp,
                textAlign = TextAlign.End,
                color = palette.onSecondary,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 7.dp)
            )
            Text(
                text = wordBack,
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                color = palette.onSecondary,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
            Text(
                text = sentenceBack,
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                color = palette.onSecondary,
                style = TextStyle(lineHeight = 18.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
        }
    }
    

}
@Composable
fun WordTranslationContent(cardType:String, modifier: Modifier = Modifier) {

}


@Composable
fun ActionButton(text: String, onClick: () -> Unit,
                 bgColor: Color, textColor: Color, modifier: Modifier = Modifier) {
    Button(onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = bgColor,
            contentColor = textColor,
        ),
        //modifier = Modifier.,
        enabled = true,
        shape = RoundedCornerShape(size = 5.dp),
    ) {
        Text(
            //modifier = Modifier.padding(all = 0.dp),
            text = text,
            fontSize = 12.sp,
            //lineHeight = 8.sp,
            textAlign = TextAlign.Center
        )
    }
}
@Composable
fun ActionButtonRow(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ActionButton(
            text = "Show answer",
            onClick = { /*TODO*/ },
            bgColor = palette.secondaryContainer,
            textColor = palette.onSecondaryContainer,
        )
        ActionButton(
            text = "I got it right",
            onClick = { /*TODO*/ },
            bgColor = palette.tertiaryContainer,
            textColor = palette.onTertiaryContainer
        )
        ActionButton(
            text = "I got it wrong",
            onClick = { /*TODO*/ },
            bgColor = palette.errorContainer,
            textColor = palette.onErrorContainer
        )
    }
}
@Composable
fun NavButtonRow(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        ActionButton(
            text = "Previous card",
            onClick = { /*TODO*/ },
            bgColor = palette.secondaryContainer,
            textColor = palette.onSecondaryContainer
        )
        ActionButton(
            text = "Next card",
            onClick = { /*TODO*/ },
            bgColor = palette.secondaryContainer,
            textColor = palette.onSecondaryContainer
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainWindowPreview() {
    palette.setDark()
    SpanishFlashCardsAndroidTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = palette.background,

            ) {
            MainWindow()
        }
    }
}