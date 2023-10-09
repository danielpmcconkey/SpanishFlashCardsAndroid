package com.example.spanishflashcardsandroid

import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spanishflashcardsandroid.ui.theme.SpanishFlashCardsAndroidTheme
import java.io.InputStream

val palette = ColorPalette()
val viewModel =  ViewModel()



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            Init(LocalContext.current)
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

@Preview(showBackground = true)
@Composable
fun MainWindowPreview() {
    Init(LocalContext.current)
    SpanishFlashCardsAndroidTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = palette.background,

            ) {
            MainWindow()
        }
    }
}
fun Init(context: Context) {

    val translationWordsFileName = "translatablewords.json"
    viewModel.init(context, translationWordsFileName)
    palette.setDark()

}
@Composable
fun MainWindow(modifier: Modifier = Modifier) {

    val streak = viewModel.streak.collectAsState().value
    val typeFront = viewModel.typeFront.collectAsState().value
    val typeBack = viewModel.typeBack.collectAsState().value
    val wordFront = viewModel.wordFront.collectAsState().value
    val wordBack = viewModel.wordBack.collectAsState().value
    val sentenceFront = viewModel.sentenceFront.collectAsState().value
    val sentenceBack = viewModel.sentenceBack.collectAsState().value
    val isHidden = viewModel.answerView.collectAsState().value == ("hidden")







    Column (verticalArrangement = Arrangement.SpaceEvenly) {

        Text(
            text = stringResource(R.string.tarjetas_didacticas_en_espanol),
            fontSize = 20.sp,
            style = TextStyle(lineHeight = 35.sp),
            textAlign = TextAlign.Center,
            color = palette.onBackground,
        )
        Text(
            text = stringResource(R.string.streak, streak),
            fontSize = 15.sp,
            textAlign = TextAlign.End,
            color = palette.onBackground,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 7.dp)
        )

        ActionButtonRow(modifier = modifier)
        TranslationCard(
            typeFront = typeFront,
            typeBack = typeBack,
            wordFront = wordFront,
            wordBack = wordBack,
            sentenceFront = sentenceFront,
            sentenceBack = sentenceBack,
            isHidden = isHidden,
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
    isHidden:Boolean,
    modifier: Modifier = Modifier) {

    val answerAlpha = if(isHidden) 0f else 1f

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
                style = TextStyle(lineHeight = 45.sp),
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
                fontSize = 15.sp,
                textAlign = TextAlign.End,
                color = palette.onSecondary,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 7.dp)
                    .alpha(answerAlpha)
            )
            Text(
                text = wordBack,
                fontSize = 35.sp,
                textAlign = TextAlign.Center,
                color = palette.onSecondary,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .alpha(answerAlpha)
            )
            Text(
                text = sentenceBack,
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                color = palette.onSecondary,
                style = TextStyle(lineHeight = 18.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .alpha(answerAlpha)
            )
        }
    }
    

}

@Composable
fun ActionButton(text: String, onClick: () -> Unit,
                 bgColor: Color, textColor: Color, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
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
            text = stringResource(R.string.show_answer),
            onClick = { viewModel.showAnswer() },
            bgColor = palette.secondaryContainer,
            textColor = palette.onSecondaryContainer,
        )
        ActionButton(
            text = stringResource(R.string.i_got_it_right),
            onClick = {
                viewModel.incrementStreak()
                viewModel.nextCard()
                viewModel.hideAnswer()
              },
            bgColor = palette.tertiaryContainer,
            textColor = palette.onTertiaryContainer
        )
        ActionButton(
            text = stringResource(R.string.i_got_it_wrong),
            onClick = {
                viewModel.resetStreak()
                viewModel.nextCard()
                viewModel.hideAnswer()
            },
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
            text = stringResource(R.string.previous_card),
            onClick = { viewModel.previousCard() },
            bgColor = palette.secondaryContainer,
            textColor = palette.onSecondaryContainer
        )
        ActionButton(
            text = stringResource(R.string.next_card),
            onClick = { viewModel.nextCard() },
            bgColor = palette.secondaryContainer,
            textColor = palette.onSecondaryContainer
        )
    }
}
