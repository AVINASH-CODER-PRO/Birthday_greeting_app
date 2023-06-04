package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(message = "Happy Birthday Abhishek!", from = "From \uD83D\uDE0E")
                }
            }
        }
    }
}


@Composable
fun GreetingText(message: String, from: String, modifier: Modifier= Modifier) {
    //Load the custom font from the assets directory
    val customFontFamily = FontFamily(
        Font(
            resId = R.font.hello,
            weight = FontWeight.Normal,
            style = FontStyle.Normal
        )
    )
    val fromFontFamily = FontFamily(
        Font(
            resId = R.font.mine,
            weight = FontWeight.Normal,
            style = FontStyle.Normal
        )
    )









    //Create a column so that text don't overlap
    Column(verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(8.dp)) {
        Text(
            text = message,
            fontSize = 60.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontFamily = customFontFamily
        )
        Text(
            text = from,
            fontSize = 40.sp,
            modifier = Modifier
                .padding(top = 50.dp)
                .align(alignment = Alignment.CenterHorizontally),
            fontStyle = FontStyle.Italic,
            fontFamily = fromFontFamily
        )
    }
    }

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.img)
    //Step 3 create a box to overlap image and texts
    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.8F,
            modifier = Modifier.fillMaxSize()
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }


}




@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        GreetingImage( stringResource(R.string.happy_birthday_text),
            stringResource(R.string.signature_text))

    }
}