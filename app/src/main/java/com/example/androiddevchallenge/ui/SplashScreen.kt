package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.dao.DogDao
import com.example.androiddevchallenge.util.DATA_IMPORTED
import com.example.androiddevchallenge.util.setBooleanPreference
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoadingProvider : PreviewParameterProvider<() -> Unit> {
    override val values: Sequence<() -> Unit> = sequenceOf(
        {}
    )
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun SplashScreen(
    @PreviewParameter(
        LoadingProvider::class
    ) onLoad: () -> Unit
) {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.doge),
            contentDescription = "Doge meme picture",
            modifier = Modifier
                .height(220.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(4.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Text(
            text = "Dogos are loading",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        val context = LocalContext.current
        val dao: DogDao

        CoroutineScope(Dispatchers.IO).launch {
            context.setBooleanPreference(DATA_IMPORTED, true)
            onLoad()
        }
    }
}
