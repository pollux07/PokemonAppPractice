package daniel.leon.pokemonapppractice.retrofit

import daniel.leon.pokemonapppractice.model.catalog.DataPokemonList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.*
import org.json.JSONObject

interface ApiInterface {

    @GET("pokemon/")
    fun getPokemonList(
        @Query("limit") limit: String,
        @Query("offset") offset: String
    ): Call<DataPokemonList>
}