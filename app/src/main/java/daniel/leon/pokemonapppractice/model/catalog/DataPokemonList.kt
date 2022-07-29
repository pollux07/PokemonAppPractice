package daniel.leon.pokemonapppractice.model.catalog

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataPokemonList(
    @SerializedName("results")
    @Expose
    val results: List<DataPokemonListInfo>? = null
) : Parcelable
