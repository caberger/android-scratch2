package at.ac.myapplication.ui.layout

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rxjava3.subscribeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import at.ac.myapplication.model.Model
import at.ac.myapplication.model.Store
import at.ac.myapplication.ui.theme.MyApplicationTheme
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class MainView {
    @Inject
    lateinit var store: Store
    @Inject
    constructor() {
    }

    fun compose(activity: ComponentActivity) {
        activity.setContent {
            MyApplicationTheme {
                val state = store.subject.subscribeAsState(initial = Model())
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(state.value.greeting)
                }
            }
        }
    }
}


@Composable
fun Greeting(greeting: String, modifier: Modifier = Modifier) {
    Text(
        text = greeting,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}