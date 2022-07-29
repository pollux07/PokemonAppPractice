package daniel.leon.pokemonapppractice.view

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import daniel.leon.pokemonapppractice.repository.Repository
import daniel.leon.pokemonapppractice.ui.theme.PokemonAppPracticeTheme
import daniel.leon.pokemonapppractice.viewmodel.PokemonListViewModel
import daniel.leon.pokemonapppractice.viewmodel.PokemonListViewModelFactory
import androidx.lifecycle.observe
import daniel.leon.pokemonapppractice.model.catalog.DataPokemonListInfo

class MainActivity : ComponentActivity() {
    private val factory by lazy { PokemonListViewModelFactory(Repository()) }
    private val pokemonListViewModel: PokemonListViewModel by viewModels { factory }
    private var pokemonList = ArrayList<DataPokemonListInfo> ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokemonAppPracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    InitObservers()
                    ShowPokemonList()
                    ShowLazyPokemons(pokemonList)
                }
            }
        }
    }

    fun InitObservers() {
        pokemonListViewModel.pokemonListData.observe(this) {
            it.let {
                pokemonList = ArrayList ()
                for (pokemonArray in  listOf(it.results)) {
                    for (result in pokemonArray!!) {
                        Log.i("PokemonObservers", "$result.name")
                        pokemonList.add(result)
                    }
                }
            }
        }
    }

    @Composable
    fun ShowLazyPokemons(pokemonList: ArrayList<DataPokemonListInfo>) {
        LazyColumn {
            items(pokemonList) { pokemon ->
                SetPokemonDescription(pokemon)
            }
        }
    }

    @Composable
    fun SetPokemonDescription(pokemon: DataPokemonListInfo) {
        Log.i("Pokemon", "$pokemon.name")
    }

    fun ShowPokemonList() {
        pokemonListViewModel.getPokemonListResponse()
    }
}

