package net.cafesilencio.demo.view

class Response<T> constructor(val status: Status, val data: T?, val error: Throwable?) {
    companion object {
        fun <T> success(data: T): Response<T> = Response(Status.SUCCESS, data, null)
        fun <T> error(error: Throwable): Response<T> =  Response(Status.ERROR, null, error)
    }
}
