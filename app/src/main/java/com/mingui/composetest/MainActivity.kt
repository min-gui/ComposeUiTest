package com.mingui.composetest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mingui.composetest.ui.theme.ComposeTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("안드입니다.")
                }
            }
        }
    }
}

//뷰
@Composable
fun Greeting(name: String) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("장민섭 ") }, backgroundColor = Color(0xfff25287)) },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Text("클릭")
            }
        }
    ) {
//        Text(text = "안녕하세요 $name!")
        MyComposableView()
    }

}

@Composable
fun MyRowItem() {
    // 호리젠탈 리니어
    Row(
        Modifier
            .padding(10.dp)
            .background(Color(0xffeaffd0))
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "안녕하세요!!",
            Modifier
                .padding(10.dp)
                .background(Color.Yellow)
        )
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = "안녕하세요!!")
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = "안녕하세요!!")
    }
}

@Composable
fun MyComposableView() {
    Log.d("TAG", "MyComposableView: ")

    //버티컬 리니어
    Column(
        Modifier
            .background(Color.Green)
            .verticalScroll(rememberScrollState())
    ) {
        for (i in 1..20) {
            MyRowItem()
        }
    }


}

//미리보기
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTestTheme {
        Greeting("헤이")
    }
}