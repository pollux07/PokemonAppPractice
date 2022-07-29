package daniel.leon.pokemonapppractice.retrofit

import okhttp3.logging.HttpLoggingInterceptor.Level
import androidx.viewbinding.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val retrofitClient: Retrofit.Builder by lazy {

        val levelType: Level
        if (BuildConfig.BUILD_TYPE.contentEquals(BuildConfig.BUILD_TYPE))
            levelType =Level.BODY else levelType = Level.NONE

        val logging = HttpLoggingInterceptor()
        logging.level = levelType

        val okhttpClient = OkHttpClient.Builder()
        okhttpClient.addInterceptor(logging)

        Retrofit.Builder()
            .client(okhttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
    }

    fun build(url: String) : ApiInterface {
        return retrofitClient
            .baseUrl(url)
            .build()
            .create(ApiInterface::class.java)
    }
}