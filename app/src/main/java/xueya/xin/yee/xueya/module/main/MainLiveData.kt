package xueya.xin.yee.xueya.module.main

import android.util.Log
import androidx.lifecycle.LiveData
import xueya.xin.yee.xueya.bean.Results

class MainLiveData : LiveData<Results>() {

    override fun onActive() {
        super.onActive()
        Log.e("AAAA", "onActive")
    }

    override fun onInactive() {
        super.onInactive()
        Log.e("AAAA", "onInactive")
    }

    fun setData(data: Results) {
        value = data
    }
}