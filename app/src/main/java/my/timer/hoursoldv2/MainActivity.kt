package my.timer.hoursoldv2

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.unit.dp

import my.timer.hoursoldv2.ui.theme.HoursOldv2Theme


class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HoursOldv2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    EditTexts()
                }
            }
        }
    }
}



@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EditTexts() {

    val mContext = LocalContext.current

    val textState = remember { mutableStateOf("") }

    val Utils = Utils(mContext)


    Column {
        Text(text = "Enter your birthday date:")

        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            var day by remember { mutableStateOf("") }
            var month by remember { mutableStateOf("") }
            var year by remember { mutableStateOf("") }



            TextField(
                value = day,
                onValueChange = { newText ->
                    day = newText
                },
                modifier = Modifier.weight(1f).padding(8.dp),

                label = { Text("Day") }
            )

            TextField(
                value = month,
                onValueChange = { newText ->
                    month = newText
                },
                modifier = Modifier.weight(1f).padding(8.dp),

                label = { Text("Month") }
            )

            TextField(
                value = year,
                onValueChange = { newText ->
                    year = newText
                },
                modifier = Modifier.weight(1f).padding(8.dp),
                label = { Text("Year") }
            )



            Button(
                onClick = {
                    Utils.calculateHours(day,month,year)

                },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Enter")
            }
        }
    }
}

