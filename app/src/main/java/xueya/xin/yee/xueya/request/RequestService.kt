package xueya.xin.yee.xueya.request

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import xueya.xin.yee.xueya.bean.MieziBean

interface RequestService {
    @GET("data/福利/20/{page}")
    fun getHomeList(@Path("page") page: String): Observable<MieziBean>
}