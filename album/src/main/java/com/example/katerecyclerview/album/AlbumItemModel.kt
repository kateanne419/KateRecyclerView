package com.example.katerecyclerview.album

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.BaseEpoxyAdapter
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.katerecyclerview.common.BaseEpoxyHolder
import kotlinx.android.synthetic.main.item_album.view.*

@EpoxyModelClass
abstract class AlbumItemModel : EpoxyModelWithHolder<AlbumItemModel.ViewHolder>() {

    override fun getDefaultLayout(): Int {
        return R.layout.item_album
    }

    @EpoxyAttribute
    lateinit var title: String

    @EpoxyAttribute
    var photo = 0

    @EpoxyAttribute
    var color = 0

    @EpoxyAttribute
    var userId = 0

    @EpoxyAttribute
    var albumId = 0

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    var clickListener: View.OnClickListener? = null

    class ViewHolder : BaseEpoxyHolder() {
        lateinit var cardView: View
        lateinit var textTitle: TextView
        lateinit var textUserId: TextView
        lateinit var textAlbumId: TextView
        lateinit var imageProfile: ImageView
        lateinit var cardBackground: ConstraintLayout

        override fun bindView(itemView: View) {
            super.bindView(itemView)
            itemView.let {
                cardView = it.card
                textTitle = it.text_title
                textUserId = it.user_id
                textAlbumId = it.album_id
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
        holder.textUserId.text = "" + userId
        holder.textAlbumId.text = "" + albumId
        holder.imageProfile.setImageResource(photo)
        holder.cardBackground.setBackgroundResource(color)
        holder.cardView.setOnClickListener(clickListener)
    }
}