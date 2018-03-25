package com.example.suzukihiroshitarou.groupiesamplefortechbook

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View


class ColumnItemDecoration constructor(margin: Int) : RecyclerView.ItemDecoration() {

    private var margin: Int = 0

    init {
        this.margin = margin
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        val adapterPosition: Int = parent.getChildAdapterPosition(view)
        if (adapterPosition != 0) {
            when(adapterPosition % 3) {
                0 -> outRect.set(margin / 2, margin, margin, margin)
                1 -> outRect.set(margin, margin, margin / 2, margin)
                else -> outRect.set(margin / 2, margin, margin / 2, margin)
            }
        }
    }
}