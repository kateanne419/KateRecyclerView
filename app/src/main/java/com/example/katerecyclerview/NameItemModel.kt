package com.example.katerecyclerview

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_name.view.*

@EpoxyModelClass(layout = R.layout.item_name)
abstract class NameItemModel : EpoxyModelWithHolder<NameItemModel.ViewHolder>() {

    @EpoxyAttribute
    lateinit var title: String

    @EpoxyAttribute
    lateinit var body: String

    @EpoxyAttribute
    var ranking = 0

    @EpoxyAttribute
    var photo = 0

    @EpoxyAttribute
    var color = 0

    @EpoxyAttribute
    var userId = 0

    @EpoxyAttribute
    var postId = 0

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    var clickListener: View.OnClickListener? = null

    class ViewHolder : BaseEpoxyHolder() {
        lateinit var cardView: View
        lateinit var textTitle: TextView
        lateinit var textBody: TextView
        lateinit var textUserId: TextView
        lateinit var textPostId: TextView
        lateinit var imageProfile: ImageView
        lateinit var cardBackground: ConstraintLayout

        override fun bindView(itemView: View) {
            super.bindView(itemView)
            itemView.let {
                cardView = it.card
                textTitle = it.text_title
                textBody = it.text_body
                textUserId = it.user_id
                textPostId = it.post_id
                imageProfile = it.profile_image
                cardBackground = it.card_item
            }
        }

    }

    override fun unbind(holder: ViewHolder) {
        super.unbind(holder)
        holder.cardView.setOnClickListener(null)
    }

    override fun bind(holder: ViewHolder) {
        super.bind(holder)
        holder.textTitle.text = title
        holder.textBody.text = body
        holder.textUserId.text = "" + userId
        holder.textPostId.text = "" + postId
        holder.imageProfile.setImageResource(photo)
        holder.cardBackground.setBackgroundResource(color)
        holder.cardView.setOnClickListener(clickListener)
    }


}