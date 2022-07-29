package daniel.leon.pokemonapppractice.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import daniel.leon.pokemonapppractice.repository.Repository

class PokemonListViewModelFactory(val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokemonListViewModel::class.java)) {
            return PokemonListViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }
}