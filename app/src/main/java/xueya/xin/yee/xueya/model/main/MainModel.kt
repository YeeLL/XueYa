package xueya.xin.yee.xueya.model.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations.switchMap
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import xueya.xin.yee.xueya.bean.NetworkState
import xueya.xin.yee.xueya.bean.Results
import xueya.xin.yee.xueya.datasource.main.MainDataSourceFactory

class MainModel : ViewModel() {

    private val gankMeiziModel: MutableLiveData<Int> = MutableLiveData()

    val resultLiveData: LiveData<PagedList<Results>> = switchMap(gankMeiziModel) {
        LivePagedListBuilder(MainDataSourceFactory(it), 20).build()
    }

    fun getData(page: Int) {
        gankMeiziModel.value = page
    }

}