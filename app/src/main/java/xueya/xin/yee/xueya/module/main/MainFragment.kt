package xueya.xin.yee.xueya.module.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_main.*
import xueya.xin.yee.xueya.R
import xueya.xin.yee.xueya.bean.Results
import xueya.xin.yee.xueya.databinding.FragmentMainBinding
import xueya.xin.yee.xueya.model.main.MainModel
import xueya.xin.yee.xueya.module.main.adapter.MainListAdapter

class MainFragment : Fragment() {

    private var mMainAdaprer: MainListAdapter = MainListAdapter()
    private lateinit var binding: FragmentMainBinding
    private var page: Int = 1
    private val mMainModel by lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProviders.of(this).get(MainModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentMainBinding>(inflater, R.layout.fragment_main, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_view.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recycler_view.adapter = mMainAdaprer
        getData.setOnClickListener {
            mMainModel.getData(page)

            var liveData = MainLiveData()
            var data = Results("11111", "", "asdfasdfasdfasdfsadfsadfsadf",
                    "", "",
                    "", "", true, "")
            liveData.observe(this, Observer{
                Log.e("gggg",it!!.desc)
            })
            liveData.setData(data)
        }

        mMainModel.resultLiveData.observe(this, Observer {
            mMainAdaprer.submitList(it)
        })


    }
}