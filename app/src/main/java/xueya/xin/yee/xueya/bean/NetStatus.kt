package xueya.xin.yee.xueya.bean

enum class Status {
    RUNNING,
    SUCCESS,
    FAILED
}

data class NetworkState constructor(
        val status: Status,
        val msg: String? = null) {
    companion object {
        val LOADING = NetworkState(Status.RUNNING)
        val LOADED = NetworkState(Status.SUCCESS)
        fun error(msg: String) = NetworkState(Status.FAILED, msg)
    }
}