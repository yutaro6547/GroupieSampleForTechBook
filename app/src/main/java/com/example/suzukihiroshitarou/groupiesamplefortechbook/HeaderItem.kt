package com.example.suzukihiroshitarou.groupiesamplefortechbook

import android.support.annotation.StringRes
import com.example.suzukihiroshitarou.groupiesamplefortechbook.databinding.ItemHeaderBinding
import com.xwray.groupie.databinding.BindableItem


open class HeaderItem(
        @StringRes private val titleResId: Int,
        @StringRes private val subTitleResId: Int? = null): BindableItem<ItemHeaderBinding>() {

    override fun bind(viewBinding: ItemHeaderBinding, position: Int) {
        viewBinding.title.setText(titleResId)
        subTitleResId?.let { viewBinding.subTitle.setText(it) }
    }

    override fun getLayout(): Int = R.layout.item_header
}