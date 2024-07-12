package com.example.jetpack_demo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jetpack_demo.R
import com.example.jetpack_demo.data.UserDataUIEvent


@Composable
fun UserInputScreen(userInputViewModel: UserInputViewModel, navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),


            ) {
            TopBar("Hi there!  \uD83D\uDE0A")
            TextComponent(
                "Let's learn about you",
                fontSize = 24.sp,
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextComponent(
                "This app will prepare a detailed report about you based on the information you provide.",
                fontSize = 18.sp,

                )
            Spacer(modifier = Modifier.height(60.dp))

            TextComponent(value = "Name", fontSize = 18.sp)

            Spacer(modifier = Modifier.height(10.dp))

            TextFieldComponent(
                onTextChanged = { name ->
                    userInputViewModel.onEvent(UserDataUIEvent.NameChanged(name))


                },
            )

            Spacer(modifier = Modifier.height(20.dp))

            TextComponent(value = "What do you like", fontSize = 18.sp)



            Row(
                modifier = Modifier.fillMaxWidth()
            ) {

                AnimalCard(
                    image = R.drawable.dog,

                    animalSelected = {
                        userInputViewModel.onEvent(UserDataUIEvent.AnimalSelected(it))
                    },
                    selected = userInputViewModel.uiState.value.animalSelected == "Dog",

                    )
                AnimalCard(
                    image = R.drawable.cat,

                    animalSelected = {
                        userInputViewModel.onEvent(UserDataUIEvent.AnimalSelected(it))
                    },
                    selected = userInputViewModel.uiState.value.animalSelected == "Cat",

                    )


            }

            Spacer(modifier = Modifier.weight(1f))

            if (userInputViewModel.isValidState()
            )
                ButtonComponent(
                    onClick = {
                    }
                )

        }


    }
}

