import com.dsilvera.kotlinarchitecture.BuildConfig
import com.dsilvera.kotlinarchitecture.data.network.WSApiInterceptor
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

private const val WS_CALL_TIMEOUT_SECONDS = 60L

fun createApiClient(): Retrofit =
    Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(wsHttpClient())
        .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
        .build()

fun wsHttpClient() : OkHttpClient =
    OkHttpClient.Builder()
        .addInterceptor(WSApiInterceptor())
        .callTimeout(WS_CALL_TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE))
        .build()








