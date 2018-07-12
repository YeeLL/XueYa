package xueya.xin.yee.xueya.module.main.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_main_list.view.*
import xueya.xin.yee.xueya.bean.Results

class MainListHolder(val parentView: View) : RecyclerView.ViewHolder(parentView) {

    fun bundTo(data: Results?) {
        Glide.with(itemView.context).load(data!!.url).into(parentView.img_view)
        parentView.content.text = data!!.desc
    }
}