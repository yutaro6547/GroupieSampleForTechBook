package com.example.suzukihiroshitarou.groupiesamplefortechbook

import android.support.annotation.DrawableRes
import com.example.suzukihiroshitarou.groupiesamplefortechbook.databinding.ItemContentBinding
import com.xwray.groupie.databinding.BindableItem


open class ContentItem(@DrawableRes private val drawableId: Int): BindableItem<ItemContentBinding>() {

    override fun bind(viewBinding: ItemContentBinding, position: Int) {
        viewBinding.contentPanel.setImageResource(drawableId)
    }

    override fun getLayout(): Int = R.layout.item_content

    override fun getSpanSize(spanCount: Int, position: Int): Int = spanCount / 3

}