package com.example.tugas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

@Composable
fun FormDataDiri(modifier: Modifier = Modifier) {
    // Variabel-variabel untuk mengingat nilai masukan dari keyboard
    var textNamaDepan by remember { mutableStateOf("") }
    var textNamaBelakang by remember { mutableStateOf("") }
    var textEmail by remember { mutableStateOf("") }
    var textTglLahir by remember { mutableStateOf("") }
    var textExperience by remember { mutableStateOf("") }

    // Variabel untuk Checkbox Skills
    var skillAndroid by remember { mutableStateOf(false) }
    var skillUIUX by remember { mutableStateOf(false) }
    var skillWeb by remember { mutableStateOf(false) }

    // Variabel-variabel untuk menyimpan data output
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tglLahir by remember { mutableStateOf("") }
    var experience by remember { mutableStateOf("") }
    var skill by remember { mutableStateOf("") }
    var isSubmitted by remember { mutableStateOf(false) }
    
    // Resource strings untuk skills
    val strAndroid = stringResource(id = R.string.skill_android)
    val strUIUX = stringResource(id = R.string.skill_uiux)
    val strWeb = stringResource(id = R.string.skill_web)

    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        // Komponen Box mengapung di atas Scaffold
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Gambar Background Header UMY
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen.header_height)),
                color = Color(0xFF004D21) // Warna hijau UMY sebagai base
            ) {
                Image(
                    painter = painterResource(id = R.drawable.header_umy),
                    contentDescription = stringResource(id = R.string.header_desc),
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Fit // Fit agar logonya tidak terpotong
                )
            }

            // Card Form mengapung di atas Scaffold/Header
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = dimensionResource(id = R.dimen.form_overlap_offset)),
                shape = RoundedCornerShape(
                    topStart = dimensionResource(id = R.dimen.form_card_corner_radius),
                    topEnd = dimensionResource(id = R.dimen.form_card_corner_radius)
                ),
                color = colorResource(id = R.color.white),
                shadowElevation = dimensionResource(id = R.dimen.card_elevation)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = dimensionResource(id = R.dimen.padding_large))
                        .padding(top = dimensionResource(id = R.dimen.padding_top_form))
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Judul Form Biodata
                    Text(
                        text = stringResource(id = R.string.form_title),
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.form_title_purple),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacer_small)))

                    // Subtitle Form
                    Text(
                        text = stringResource(id = R.string.form_subtitle),
                        style = MaterialTheme.typography.bodySmall,
                        color = colorResource(id = R.color.form_subtitle_gray),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacer_medium)))

                    // Input Nama Depan & Nama Belakang (Sejajar / Row)
                    Row(modifier = Modifier.width(dimensionResource(id = R.dimen.field_width_full))) {
                        OutlinedTextField(
                            value = textNamaDepan,
                            singleLine = true,
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.field_corner_radius)),
                            modifier = Modifier.weight(1f),
                            label = { Text(text = stringResource(id = R.string.label_nama_depan)) },
                            onValueChange = { textNamaDepan = it },
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = colorResource(id = R.color.form_title_purple),
                                unfocusedBorderColor = colorResource(id = R.color.border_gray)
                            )
                        )
                        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.spacer_small)))
                        OutlinedTextField(
                            value = textNamaBelakang,
                            singleLine = true,
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.field_corner_radius)),
                            modifier = Modifier.weight(1f),
                            label = { Text(text = stringResource(id = R.string.label_nama_belakang)) },
                            onValueChange = { textNamaBelakang = it },
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = colorResource(id = R.color.form_title_purple),
                                unfocusedBorderColor = colorResource(id = R.color.border_gray)
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacer_small)))

                    // Input Email (Full Width)
                    OutlinedTextField(
                        value = textEmail,
                        singleLine = true,
                        shape = RoundedCornerShape(dimensionResource(id = R.dimen.field_corner_radius)),
                        modifier = Modifier.width(dimensionResource(id = R.dimen.field_width_full)),
                        label = { Text(text = stringResource(id = R.string.label_email)) },
                        onValueChange = { textEmail = it },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = colorResource(id = R.color.form_title_purple),
                            unfocusedBorderColor = colorResource(id = R.color.border_gray)
                        )
                    )

                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacer_small)))
                }
            }
        }
    }
}