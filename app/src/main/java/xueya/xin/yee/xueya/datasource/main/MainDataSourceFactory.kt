package xueya.xin.yee.xueya.datasource.main

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import xueya.xin.yee.xueya.bean.NetworkState
import xueya.xin.yee.xueya.bean.Results


class MainDataSourceFactory(val page: Int) : DataSource.Factory<Int, Results>() {
    override fun create(): DataSource<Int, Results> {
        return MainPageKeyedDataSource(page)
    }
}