package xueya.xin.yee.xueya.module.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import xueya.xin.yee.xueya.R
import xueya.xin.yee.xueya.bean.Results
import xueya.xin.yee.xueya.module.main.holder.MainListHolder

class MainListAdapter : PagedListAdapter<Results, MainListHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListHolder {
        return MainListHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_main_list, parent, false))
    }

    override fun onBindViewHolder(holder: MainListHolder, position: Int) {
        holder.bundTo(getItem(position))
    }


    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Results>() {
            override fun areItemsTheSame(oldItem: Results, newItem: Results):
                    Boolean = oldItem._id == newItem._id

            override fun areContentsTheSame(oldItem: Results, newItem: Results):
                    Boolean = oldItem == newItem
        }
    }
}