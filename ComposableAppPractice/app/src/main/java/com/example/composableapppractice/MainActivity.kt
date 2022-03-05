package com.example.composableapppractice

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composableapppractice.ui.theme.ComposableAppPracticeTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
/*
            ComposableAppPracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
*/

/*
            Column(

                modifier = Modifier.background(color = Color.Green).fillMaxSize()
                    .padding(top = 100.dp)
                    .border(10.dp, Color.Magenta).padding(10.dp)
                    .border(10.dp, Color.Blue).padding(10.dp),


                verticalArrangement = Arrangement.Top,
            ) {
                Text(text = "dd", fontStyle = FontStyle.Italic)
                Text(
                    text = "hi android compose", fontSize = 20.sp,
                    modifier = Modifier.offset(0.dp, 0.dp).height(100.dp)
                        .background(color = Color.White)
                        .border(10.dp, Color.Blue).padding(10.dp).clickable {
                            Toast.makeText(this@MainActivity, "Test", Toast.LENGTH_SHORT).show()
                        },
                )
                Text(text = "hi ompose", textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "hi e", textAlign = TextAlign.Center)
            }
*/


            val painter = painterResource(R.drawable.andro)
            val description = "Hi android "
            val title = "Image card"

/*
            Box(modifier = Modifier.padding(10.dp))
            {

                ImageCard(
                    painter = painter,
                    contentDes = description,
                    title = title,
                    context = this@MainActivity,
                    modifier = Modifier.requiredHeight(200.dp).fillMaxWidth(0.5f)
                )
            }
*/


//            ColorBox(Modifier.fillMaxSize())

//            Snackbar(backgroundColor = Color.Black) { Text(text = "hello Android!") }


            // button click and snackbar

            /* var textFieldState by remember { mutableStateOf("") }
             val scaffoldState = rememberScaffoldState()
             val scope = rememberCoroutineScope()


             Scaffold(
                 modifier = Modifier.fillMaxSize(),
                 scaffoldState = scaffoldState
             ) {
                 Column(
                     horizontalAlignment = Alignment.CenterHorizontally,
                     verticalArrangement = Arrangement.Center,
                     modifier = Modifier.fillMaxSize().padding(horizontal = 30.dp)
                 ) {
                     OutlinedTextField(
                         value = textFieldState,
                         label = { Text("Enter your name") },
                         onValueChange = { textFieldState = it },
                         singleLine = true
                     )
                     Spacer(modifier = Modifier.height(20.dp))
                     Button(onClick = {
                         scope.launch {
                             scaffoldState.snackbarHostState.showSnackbar("Hello $textFieldState")
                         }
                     }

                     ) {
                         Text(text = "Click me")
                     }

                 }
             }*/


            // List
            val scrollState = rememberScrollState()
/*
            Column(
                modifier = Modifier.verticalScroll(scrollState)
                    .fillMaxSize()
            ) {
                for (i in 1..100) {
                    Text(
                        modifier = Modifier.fillMaxWidth().padding(20.dp),
                        text = "item $i", textAlign = TextAlign.Center, fontSize = 20.sp
                    )
                }

            }
*/

            // LazyLoad
/*
            LazyColumn {
*/
/*
                items(1000) {
                    Text(
                        modifier = Modifier.fillMaxWidth().padding(20.dp),
                        text = "item $it", textAlign = TextAlign.Center, fontSize = 20.sp
                    )
                }
*//*


                itemsIndexed(listOf("Hello", "Android", "World")) { index, s ->
                    Text(
                        modifier = Modifier.fillMaxWidth().padding(20.dp),
                        text = " $s", textAlign = TextAlign.Center, fontSize = 20.sp
                    )
                }

            }
*/

            /*    var sizeState by remember { mutableStateOf(200.dp) }

                val size by animateDpAsState(
                    targetValue = sizeState,
    //            tween(3000, delayMillis = 300, LinearOutSlowInEasing)
    //                spring(Spring.DampingRatioHighBouncy)
                    keyframes {
                        durationMillis = 5000
                        sizeState at 0 with LinearEasing
                        sizeState * 1.5f at 1000 with FastOutLinearInEasing
                        sizeState * 2f at 5000
                    }
                )
                Box(
                    modifier = Modifier.size(size).background(Color.Red),
                    contentAlignment = Alignment.Center
                ) {
                    Button(onClick = {
                        sizeState += 50.dp
                    }) {
                        Text("Increase box size")
                    }


                }*/


            Box(
                modifier = Modifier.fillMaxSize().background(color = Color.Red),
                contentAlignment = Alignment.Center
            ) {
//                AnimateProgressBar(percentage = 1.0f, number = 100)
                CircularImage()
            }


        }

    }
}


@Composable
fun AnimateProgressBar(
    percentage: Float,
    number: Int,
    radius: Dp = 50.dp, color: Color = Color.Green,
    strokeWidth: Dp = 8.dp,
    animationDuration: Int = 1000,
    animDelay: Int = 0
) {
    var animationPlayed by remember {
        mutableStateOf(false)
    }

    val currentPercentage =
        animateFloatAsState(
            targetValue = if (animationPlayed) percentage else 0f,
            animationSpec = tween(durationMillis = animationDuration, delayMillis = animDelay)
        )


    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }

    Box(contentAlignment = Alignment.Center, modifier = Modifier.size(radius * 2f))
    {
        Canvas(modifier = Modifier.size(radius * 2f)) {
            drawArc(
                color = color,
                startAngle = -90f,
                sweepAngle = 360 * currentPercentage.value,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )

        }

        Text(
            text = (currentPercentage.value * number).toInt().toString(),
            color = Color.Red
        )


    }


}


@Composable
fun ColorBox(modifier: Modifier = Modifier) {
    val color = remember { mutableStateOf(Color.Yellow) }

    Box(
        modifier = modifier.background(color.value)
            .clickable {
                color.value = Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(), 1f
                )
            }


    )


}


@Composable
fun ImageCard(
    painter: Painter,
    contentDes: String,
    title: String,
    modifier: Modifier = Modifier,
    context: Context
) {
    Card(
        modifier = modifier.fillMaxWidth().clickable {
            Toast.makeText(context, "Test", Toast.LENGTH_SHORT).show()
        },
        shape = RoundedCornerShape(15.dp),
        elevation = 20.dp,
    ) {
        Box(modifier = Modifier.height(300.dp)) {
            Image(
                painter = painter, contentDescription = contentDes, contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier.background(
                    brush = Brush.verticalGradient(
                        listOf(
                            Color.Transparent,
                            Color.Black,
                        ), startY = 300f
                    )
                ).fillMaxSize()
            )


            Box(
                modifier = Modifier.fillMaxSize().padding(12.dp).background(color = Color.Red),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    title, style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp, fontFamily = FontFamily(Font(R.font.fasolid))
                    )
                )
            }

        }
    }

}


@Composable
fun CircularImage() {

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(R.drawable.andro),
            modifier = Modifier.clip(CircleShape).size(200.dp)
                .border(shape = CircleShape, width = 10.dp, color = Color.Black),

            contentDescription = "image"
        )
    }


}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun DefaultPreview() {
    ComposableAppPracticeTheme {
//        Greeting("Gol")
    }
}