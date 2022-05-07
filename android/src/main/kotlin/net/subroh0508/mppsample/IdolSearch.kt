package net.subroh0508.mppsample

import android.graphics.Color as AndroidColor
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import net.subroh0508.data.infra.IdolsRepository
import net.subroh0508.data.model.Idol

@Composable
fun IdolSearch() {
    val repository: IdolsRepository by inject()
    val coroutineScope = rememberCoroutineScope()

    var idols by remember { mutableStateOf(listOf<Idol>()) }
    var query by remember { mutableStateOf("") }

    Column {
        Row(modifier = Modifier.height(IntrinsicSize.Min)) {
            OutlinedTextField(
                query,
                onValueChange = { query = it },
                modifier = Modifier.weight(1F)
                    .padding(8.dp),
            )
            TextButton(
                onClick = {
                    coroutineScope.launch {
                        idols = repository.search(query.takeIf(String::isNotBlank))
                    }
                },
                modifier = Modifier.wrapContentWidth()
                    .fillMaxHeight()
                    .padding(8.dp),
            ) {
                Text("検索")
            }
        }

        Divider()

        IdolLists(idols)
    }
}

@Composable
private fun IdolLists(idols: List<Idol>) {
    LazyColumn {
        items(idols) {
            Column(modifier = Modifier.padding(8.dp)) {
                Text(it.name, style = MaterialTheme.typography.h6)
                Divider(color = it.toColor())
                Text(it.yomi)
            }

            Divider()
        }
    }
}

private fun Idol.toColor() = AndroidColor.parseColor(color).let { hex ->
    Color(
        red = (hex and 0xFF0000) shr 16,
        green = (hex and 0xFF00) shr 8,
        blue = (hex and 0xFF),
    )
}
