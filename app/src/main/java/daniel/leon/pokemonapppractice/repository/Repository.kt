package daniel.leon.pokemonapppractice.repository

import androidx.lifecycle.MutableLiveData
import daniel.leon.pokemonapppractice.config.WebConfig
import daniel.leon.pokemonapppractice.model.catalog.DataPokemonList
import daniel.leon.pokemonapppractice.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    val dataPokemonList = MutableLiveData<DataPokemonList>()

    val errorResponse = MutableLiveData<String>()

    fun getPokemonList() {
        val call =RetrofitClient.build(WebConfig.POKEMON_LIST_URL).getPokemonList("20", "20")

        call.enqueue(object: Callback<DataPokemonList> {
            override fun onFailure(call: Call<DataPokemonList>, t: Throwable) {
                errorResponse.value = "Error Appointments : $t"
            }

            override fun onResponse(
                call: Call<DataPokemonList>,
                response: Response<DataPokemonList>
            ) {
                val data = response.body()!!
                dataPokemonList.value = data
            }
        })
    }
}