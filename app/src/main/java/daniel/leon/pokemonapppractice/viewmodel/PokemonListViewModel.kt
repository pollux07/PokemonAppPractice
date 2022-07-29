package daniel.leon.pokemonapppractice.viewmodel

import androidx.lifecycle.ViewModel
import daniel.leon.pokemonapppractice.repository.Repository

class PokemonListViewModel(val repository: Repository) : ViewModel() {
    var pokemonListData = repository.dataPokemonList
    var errorResponse = repository.errorResponse

    fun getPokemonListResponse() {
        repository.getPokemonList()
    }
}