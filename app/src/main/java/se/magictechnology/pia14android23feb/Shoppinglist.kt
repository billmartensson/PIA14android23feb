package se.magictechnology.pia14android23feb

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


data class ShopItem(
    val shopname : String,
    val shopamount : Int,
    var shopdone : Boolean
)

@Composable
fun Shoppinglist() {

    var shopitems = remember { mutableStateListOf<ShopItem>() }

    var addshopname by remember { mutableStateOf("") }
    var addshopamount by remember { mutableStateOf("1") }

    fun addshop() {
        addshopamount.toIntOrNull()?.let { amount ->
            var newshop = ShopItem(addshopname, amount, false)

            shopitems.add(newshop)

            addshopname = ""
        }

    }

    Column(modifier = Modifier.fillMaxSize()) {

        Row {

            TextField(modifier = Modifier
                .weight(1f)
                ,
                value = addshopname,
                onValueChange = { addshopname = it }
            )

            TextField(modifier = Modifier
                .width(60.dp)
                .padding(horizontal = 5.dp)
                ,
                value = addshopamount,
                onValueChange = { addshopamount = it }
            )

            Button(onClick = {
                addshop()
            }) {
                Text("ADD")
            }
        }

        LazyColumn() {
            items(shopitems) { shopthing ->
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .clickable(onClick = {
                        shopitems[0].shopdone = true
                    })
                    ,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(shopthing.shopname, modifier = Modifier.weight(1f))
                    Text("${shopthing.shopamount}")

                    if(shopthing.shopdone) {
                        Text("X", modifier = Modifier.padding(horizontal = 10.dp))
                    } else {
                        Text("O", modifier = Modifier.padding(horizontal = 10.dp))
                    }

                    Button(onClick = {
                        shopitems.remove(shopthing)
                    }) {
                        Text("DELETE")
                    }

                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ShoppinglistPreview() {
    Shoppinglist()
}

fun fancycode() {
    var number = 7

}

fun nicefunction() {
    var goodthings = true
}

// En ändring på webb2
// mer ändring
// Ändring BBBBBBBBBB
// Ändring AAAAAAAAAAA
