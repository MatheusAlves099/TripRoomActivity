package br.senai.sp.jandira.activelogintriproom.model

import androidx.compose.ui.graphics.painter.Painter

data class Categories(
    var id: Int = 0,
    var image: Painter? = null,
    var name: String = ""
) {

}