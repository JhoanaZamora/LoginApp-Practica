
package com.example.loginapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Azul = Color(0xFF2855D9)
private val Fondo = Color(0xFFF3F6FC)
private val AzulOscuro = Color(0xFF172B59)
private val Gris = Color(0xFF68758F)
private val Borde = Color(0xFFD6DFEF)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme(
                colorScheme = lightColorScheme(
                    primary = Azul,
                    onPrimary = Color.White,
                    background = Fondo,
                    surface = Color.White,
                    onSurface = AzulOscuro
                )
            ) {
                LoginScreen()
            }
        }
    }
}

@Composable
fun LoginScreen() {
    var correo by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }
    var mostrarContrasena by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Fondo)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 22.dp, vertical = 90.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(18.dp))

        // Logo con iniciales
        Box(
            modifier = Modifier
                .size(76.dp)
                .background(Azul, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "JZ",
                color = Color.White,
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Bienvenida
        Text(
            text = "¡Hola de nuevo!",
            fontSize = 21.sp,
            fontWeight = FontWeight.Bold,
            color = AzulOscuro
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Inicia sesión para continuar",
            fontSize = 12.sp,
            color = Gris
        )

        Spacer(modifier = Modifier.height(28.dp))

        // Campo de correo
        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("Correo electrónico", fontSize = 13.sp)
            },
            singleLine = true,
            shape = RoundedCornerShape(15.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Azul,
                unfocusedBorderColor = Borde,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Campo de contraseña
        OutlinedTextField(
            value = contrasena,
            onValueChange = { contrasena = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("Contraseña", fontSize = 13.sp)
            },
            singleLine = true,
            shape = RoundedCornerShape(15.dp),
            visualTransformation = if (mostrarContrasena)
                VisualTransformation.None
            else
                PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            trailingIcon = {
                TextButton(
                    onClick = {
                        mostrarContrasena = !mostrarContrasena
                    }
                ) {
                    Text(
                        if (mostrarContrasena) "Ocultar" else "Mostrar",
                        fontSize = 10.sp
                    )
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Azul,
                unfocusedBorderColor = Borde,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            )
        )

        // Recuperar contraseña
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(onClick = {}) {
                Text(
                    "¿Olvidaste tu contraseña?",
                    fontSize = 11.sp,
                    color = Azul
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Botón principal
        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Azul
            )
        ) {
            Text(
                "Iniciar sesión",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(28.dp))

        Text(
            "¿No tienes cuenta?",
            fontSize = 12.sp,
            color = Gris
        )

        TextButton(onClick = {}) {
            Text(
                "Crear cuenta",
                fontSize = 12.sp,
                color = Azul
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            "9:41",
            fontSize = 10.sp,
            color = Gris
        )
    }
}
