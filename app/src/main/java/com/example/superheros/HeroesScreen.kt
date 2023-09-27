package com.example.superheros

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.superheros.model.Hero

@Composable
fun HeroText(@StringRes name:Int,@StringRes desc:Int,modifier: Modifier=Modifier){
    Column (modifier=modifier){
        Text(
            text = stringResource(name),
            style = MaterialTheme.typography.displayLarge
        )
        Spacer(Modifier.height(10.dp))
        Text(text = stringResource(desc),style=MaterialTheme.typography.labelSmall)
    }
}
@Composable
fun HeroImage(@DrawableRes image:Int,modifier: Modifier=Modifier){
        Box(modifier = Modifier
            .size(72.dp)
            .clip(RoundedCornerShape(8.dp))){
            Image(
                painterResource(image),
                contentDescription=null,
                alignment = Alignment.TopCenter,
                contentScale = ContentScale.FillWidth
            )
        }
}
@Composable
fun HeroCard(hero:Hero,modifier: Modifier=Modifier){

    ElevatedCard (
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .sizeIn(minHeight = 72.dp)
                .padding(16.dp)
                .clip(MaterialTheme.shapes.small)

        ){
            HeroText(name = hero.name, desc =hero.description )
            Spacer(Modifier.weight(1f))
            HeroImage(image = hero.imageResourceId)
        }
    }
}

