package daniel.leon.pokemonapppractice.model.catalog

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataPokemonListInfo(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) : Parcelable