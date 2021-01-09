package com.example.katerecyclerview

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import kotlinx.android.synthetic.main.item_name.view.*

@EpoxyModelClass(layout = R.layout.item_name)
abstract class NameItemModel : EpoxyModelWithHolder<NameItemModel.ViewHolder>() {

    @EpoxyAttribute
    lateinit var name: String

    @EpoxyAttribute
    lateinit var info: String

    @EpoxyAttribute
    var ranking = 0

    @EpoxyAttribute
    var photo = 0

    @EpoxyAttribute
    var color = 0

    class ViewHolder : BaseEpoxyHolder() {
        lateinit var textName: TextView
        lateinit var textInfo: TextView
        lateinit var textRanking: TextView
        lateinit var imageProfile: ImageView
        lateinit var cardBackground: ConstraintLayout

        override fun bindView(itemView: View) {
            super.bindView(itemView)
            itemView.let {
                textName = it.text_name
                textInfo = it.text_info
                textRanking = it.ranking
                imageProfile = it.profile_image
                cardBackground = it.card_item
            }
        }
    }

    override fun bind(holder: ViewHolder) {
        super.bind(holder)
        holder.textName.text = name
        holder.textInfo.text = info
        holder.textRanking.text = "" + ranking
        holder.imageProfile.setImageResource(photo)
        holder.cardBackground.setBackgroundResource(color)
    }


}