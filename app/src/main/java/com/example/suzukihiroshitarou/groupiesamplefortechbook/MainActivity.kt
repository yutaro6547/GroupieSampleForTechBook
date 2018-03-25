package com.example.suzukihiroshitarou.groupiesamplefortechbook

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.example.suzukihiroshitarou.groupiesamplefortechbook.databinding.ActivityMainBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import android.support.v4.content.res.TypedArrayUtils.getResourceId
import java.util.*
import android.support.v4.content.res.TypedArrayUtils.getResourceId


class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    private val imageArray by lazy {
        applicationContext.resources.obtainTypedArray(R.array.image_list)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val groupAdapter = GroupAdapter<ViewHolder>().apply {
            spanCount = 3
        }

        val contentItem = generateItem()
        imageArray.recycle()

        Section(HeaderItem(R.string.test_title, R.string.test_sub_title)).apply {
            add(ColumnGroup(contentItem))
            groupAdapter.add(this)
        }


        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, groupAdapter.spanCount).apply {
                spanSizeLookup = groupAdapter.spanSizeLookup
            }
            adapter = groupAdapter
        }
    }

    private fun generateItem(): MutableList<ContentItem> {
        val rnd = Random()
        return MutableList(12) {
            ContentItem(imageArray.getResourceId(rnd.nextInt(12), 0))
        }
    }
}