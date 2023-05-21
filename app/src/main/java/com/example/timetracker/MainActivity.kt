package com.example.timetracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.timetracker.ui.theme.TimeTrackerTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { // main
        super.onCreate(savedInstanceState)
        setContent {
            TimeTrackerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background)
                {
                    GreetingImage(
                        stringResource(R.string.happy_birthday) + " Lorenz!",
                        stringResource(R.string.from) + " Stina")
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(top = 16.dp)
                .padding(end = 16.dp)
                .align(alignment = Alignment.End)
        )
    }
}

@Composable
fun ComposeArticleChallenge(modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.bg_compose_background)
    Column(modifier){
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = stringResource(R.string.jetpack_compose_tutorial_heading),
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = stringResource(R.string.jetpack_compose_tutorial_text1),
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = stringResource(R.string.jetpack_compose_tutorial_text2),
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp)
        )
    }

}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.androidparty)
    Box (modifier){
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        GreetingText(
            message,
            from,
            Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

//Drawables in te nodpi-Folder arent resized!
//Ctrl + leftClick to go to documentation
//SP unit is the same size as the DP unit, but it resizes based on the user's preferred text size under phone settings

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TimeTrackerTheme {
        //GreetingImage(
            //stringResource(R.string.happy_birthday) + " Lorenz!",
            //stringResource(R.string.from) + " Stina")
        ComposeArticleChallenge()
    }
}
