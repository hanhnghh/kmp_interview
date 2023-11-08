package com.example.myapplication.android.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.myapplication.data.model.TeamModel
import com.example.myapplication.view_model.PocViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(pocViewModel: PocViewModel = getViewModel()) {

    LazyColumn {
        items(pocViewModel.teamDataState.value) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(elevation = 2.dp)
            ) {
                TeamRow(it)
            }
        }
    }

}

@Composable
fun TeamRow(model: TeamModel) {
    Column {
        Divider(
            modifier = Modifier
                .height(1.dp)
                .padding(horizontal = 16.dp),
            color = Gray
        )
        Row(
            modifier = Modifier
                .heightIn(min = 64.dp)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = Modifier.size(42.dp),
                model = model.logo,
                contentDescription = "logo"
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = model.name, fontSize = 18.sp, style = TextStyle(Color.White))
        }
    }
}