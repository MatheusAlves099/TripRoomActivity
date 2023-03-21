package br.senai.sp.jandira.activelogintriproom.dao.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.activelogintriproom.R
import br.senai.sp.jandira.activelogintriproom.model.Categories

class CategoriesRepository {

    companion object {
        @Composable
        fun CategoriesList(): List<Categories> {
            return listOf<Categories>(
                Categories(
                    id = 1,
                    name = "Mountain",
                    image = painterResource(id = R.drawable.mountains)
                ),
                Categories(
                    id = 2,
                    name = "Snow",
                    image = painterResource(id = R.drawable.ski)
                ),
                Categories(
                    id = 3,
                    name = "Beach",
                    image = painterResource(id = R.drawable.beach)
                ),
            )
        }
    }
}