package xueya.xin.yee.xueya.datasource.main

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import xueya.xin.yee.xueya.bean.MieziBean
import xueya.xin.yee.xueya.bean.NetworkState
import xueya.xin.yee.xueya.bean.Results
import xueya.xin.yee.xueya.request.RequestApi

class MainPageKeyedDataSource(val page: Int) : PageKeyedDataSource<Int, Results>() {
    val netStatusModel: MutableLiveData<NetworkState> = MutableLiveData()
    @SuppressLint("CheckResult")
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Results>) {
//        netStatusModel.value = NetworkState.LOADING
        /*   var list = ArrayList<Results>()
           list.add(Results("11111", "", "asdfasdfasdfasdfsadfsadfsadf",
                   "", "",
                   "", "", true, ""))
           callback.onResult(list, params.requestedLoadSize, page)*/

        RequestApi.requestService.getHomeList(page.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    callback.onResult(it.results, null, page + 1)
                }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Results>) {
//        netStatusModel.value = NetworkState.LOADING
        getData(callback = {
            if (it.error) {
//                netStatusModel.value = NetworkState.error("error")
                return@getData
            }
//            netStatusModel.value = NetworkState.LOADED
            callback.onResult(it.results, params.key + 1)
        }, params = params.key)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Results>) {
    }

    @SuppressLint("CheckResult")
    fun getData(callback: (MieziBean) -> Unit, params: Int) {
        RequestApi.requestService.getHomeList(params.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    callback(it)
                }
    }
}