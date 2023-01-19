package com.example.businesscardapp

import android.graphics.drawable.Icon

import android.os.Bundle
import android.provider.Settings.Global.getString
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email

import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MergeSections()
                }
            }
        }
    }
}

@Composable
fun MergeSections(){
    SectionOneWithImageAndText(
        fullName = stringResource(R.string.full_name),
        title = stringResource(R.string.title_desc)
    )
    SectionTwoWithContactInfo()
}
@Composable
private fun SectionOneWithImageAndText(
    fullName: String,
    title: String
) {
    val image = painterResource(R.drawable.android_logo)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image, contentDescription = null,
            modifier = Modifier
                .size(100.dp, 100.dp)
                .fillMaxWidth()
        )
        Text(
            text = fullName,
            fontSize = 50.sp
        )
        Text(
            text = title,
            fontSize = 17.sp,
            color = Color.Cyan,
            fontWeight = FontWeight.Bold
        )

    }
}


@Composable
private fun SectionTwoWithContactInfo() {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 50.dp)
    ) {
        Divider(
            color = Color.White, modifier = Modifier
                .fillMaxWidth()
                .width(1.dp)
        )
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            Icon(
                Icons.Rounded.Phone,
                contentDescription = null,
            )
            Spacer(Modifier.width(20.dp))
            Text(
                text = stringResource(R.string.phone),

            )
        }
        Divider(
            color = Color.White, modifier = Modifier
                .fillMaxWidth()
                .width(1.dp)
        )
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            Icon(
                Icons.Rounded.Share,
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(60.dp))
            Text(
                text = stringResource(R.string.share),

            )
        }
        Divider(
            color = Color.White, modifier = Modifier
                .fillMaxWidth()
                .width(1.dp)
        )
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            Icon(
                Icons.Rounded.Email,
                contentDescription = null
            )
            Spacer(Modifier.width(20.dp))
            Text(
                text = stringResource(R.string.email),
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardAppTheme {
        MergeSections()
    }
}