package com.example.contactsapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contactsapp.data.DataSource
import com.example.contactsapp.data.constants.Constants
import com.example.contactsapp.model.Contact
import com.example.contactsapp.ui.theme.ContactsAppTheme
import com.example.contactsapp.ui.theme.Gray

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContactsAppTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = stringResource(R.string.contacts_app)) },
                            actions = {
                                Icon(
                                    painter = painterResource(id = R.drawable.baseline_home_24),
                                    contentDescription = "Home Number",
                                    modifier = Modifier
                                        .padding(8.dp)
                                        .size(24.dp)
                                        .clickable {
                                            val intent = Intent(
                                                Intent.ACTION_DIAL
                                            ).apply {
                                                data =
                                                    Uri.parse("tel:" + Constants.HOME_PHONE_NUMBER)
                                            }

                                            try {
                                                startActivity(intent)
                                            } catch (e: Exception) {
                                                Log.d("trace", "${e.localizedMessage} ")
                                            }
                                        }

                                )
                            },
                        )
                    },


                    ) { paddingValues ->
                    ContactScreen(
                        Modifier
                            .padding(paddingValues)
                            .fillMaxSize()

                    )
                }
            }
        }
    }
}

@Composable
fun ContactScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
    ) {
        ContactList(DataSource().getContactsData())
    }
}


@Composable
fun ContactList(contacts: List<Contact>) {
    LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 128.dp)) {
        items(contacts) {
            ContactItem(contact = it)
        }
    }
}

@Composable
fun ContactItem(contact: Contact, modifier: Modifier = Modifier) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val context = LocalContext.current
    Box(
        modifier = modifier.clickable {
            val intent = Intent(
                Intent.ACTION_DIAL
            ).apply { data = Uri.parse("tel:" + contact.number) }

            try {
                context.startActivity(intent)
            } catch (e: Exception) {
                Log.d("trace", "${e.localizedMessage} ")
            }
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .background(
                    color = Gray
                )
                .wrapContentSize()
        ) {
            Image(
                painter = painterResource(id = contact.image),
                contentDescription = contact.name,
                modifier = modifier.width(screenWidth / 3)
            )
            Text(
                text = contact.name,
                fontSize = 20.sp,

                )
            SelectionContainer {
                Text(
                    text = contact.number,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun ContactItemPreview() {
//    ContactItem()
}