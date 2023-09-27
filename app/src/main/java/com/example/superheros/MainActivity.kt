package com.example.superheros

import Topbar
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring.DampingRatioLowBouncy
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.animation.fadeOut
import com.example.superheros.model.HeroesRepo
import com.example.superheros.ui.theme.SuperherosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperherosTheme{

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HeroApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroApp(){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
         topBar = { Topbar() }
    ) {
        val visibleState = remember {
            MutableTransitionState(false).apply {
                //start animation immediately
                targetState = true
            }
        }
        //Fade in entry animation for the entire list
        AnimatedVisibility(
            visibleState = visibleState,
            enter = fadeIn(spring(dampingRatio = DampingRatioLowBouncy)),
            exit = fadeOut(),

        ) {
            
        }
        LazyColumn(contentPadding = it){
        itemsIndexed(HeroesRepo.heroes){
            _,hero->
            HeroCard(hero = hero)

        }
    }
    }
}

@Preview(showBackground = false)
@Composable
fun GreetingPreview() {
    SuperherosTheme {
        HeroApp()
    }
}