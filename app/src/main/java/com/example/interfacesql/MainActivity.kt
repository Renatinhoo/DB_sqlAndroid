package com.example.interfacesql


import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.interfacesql.db.DBHandler


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()

        }
    }
}



















@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(){

    var coursename by remember { mutableStateOf("") }
    var courseduration by remember { mutableStateOf("") }
    var coursetracks by remember { mutableStateOf("") }
    var coursedescription by remember { mutableStateOf("") }
    val context = LocalContext.current
    var dbHandler: DBHandler = DBHandler(context)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "Banco de Dados SQL Android")

        OutlinedTextField(
            value = coursename,
            onValueChange = { coursename = it },
            label = { Text("Nome do Curso") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = courseduration,
            onValueChange = { courseduration = it },
            label = { Text("Duração do curso") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = coursetracks,
            onValueChange = { coursetracks = it },
            label = { Text("Caminhos do curso") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = coursedescription,
            onValueChange = { coursedescription = it },
            label = { Text("Descrição do curso") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )














        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    dbHandler.addNewCourse(
                        coursename,
                        courseduration,
                        coursedescription,
                        coursetracks
                    )
                    Toast.makeText(context, "Course Added to Database", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                Text(text = "Add Course to Database")
            }

            Button(
                onClick = {

                },
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(text = "Read Courses to Database")
            }
        }
    }
}











