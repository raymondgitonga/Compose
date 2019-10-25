package com.tosh.compose

import  android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.Model
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.CrossAxisAlignment
import androidx.ui.layout.Spacing
import androidx.ui.material.Button
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
import androidx.ui.material.surface.Surface
import androidx.ui.material.themeTextStyle
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomTheme {
                  Greeting("Raymond")
            }
            myApp{
//                Greeting("Raymond")
                MyScreenShot()
            }
        }
    }
}

@Composable
fun myApp(child:@Composable()()-> Unit){
    MaterialTheme{
        Surface(color = Color.Magenta) {
            child()
        }
    }
}

@Composable
fun MyScreenShot(appState: AppState = AppState()){
    Column(crossAxisAlignment = CrossAxisAlignment.Center){
        Column(modifier = Flexible(1f),crossAxisAlignment = CrossAxisAlignment.Center) {
            Greeting(name = "Gitonga")
            Divider(color = Color.Black)
            Greeting(name = "Tosh")
        }

        Counter(appState.counterState)
    }
}
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!",
            modifier = Spacing(24.4.dp),
            style = +themeTextStyle { h1 })
}

class AppState(val counterState: CounterState = CounterState())

@Composable
fun Counter(state: CounterState){
    Button(text = "I've been clicked ${state.count} times",onClick = {
        state.count++
    })
}

@Model
class CounterState(var count: Int = 0)

@Preview
@Composable
fun DefaultPreview() {
    myApp {
//        Greeting("Android")
        MyScreenShot()
    }
}
