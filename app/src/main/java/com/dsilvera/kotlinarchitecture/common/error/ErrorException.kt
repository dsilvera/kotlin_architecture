import okhttp3.Response
import java.io.IOException
import java.net.HttpURLConnection

class NoInternetConnectionException : IOException("Cannot connect to the server")

class WSException(val code: Int, val type: Type, message: String?) : IOException(message) {
    constructor(response: Response) : this(response.code(), response.type(), response.message())

    enum class Type {
        NOT_FOUND,
        UNAUTHORIZED,
        UPDATE_REQUIRED,
        FORBIDDEN,
        OTHER
    }
}

private fun Response.type(): WSException.Type {
    return when (code()) {
        HttpURLConnection.HTTP_NOT_FOUND -> WSException.Type.NOT_FOUND
        HttpURLConnection.HTTP_UNAUTHORIZED -> WSException.Type.UNAUTHORIZED
        426 -> WSException.Type.UPDATE_REQUIRED
        HttpURLConnection.HTTP_FORBIDDEN -> WSException.Type.FORBIDDEN
        else -> WSException.Type.OTHER
    }
}
