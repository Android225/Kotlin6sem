package com.example.kotlin6sem

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class TaskAdapter(context: Context, tasks: List<Task>) :
    ArrayAdapter<Task>(context, R.layout.list_item, tasks) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        }

        val currentItem = getItem(position)

        val titleTextView: TextView = itemView!!.findViewById(R.id.textViewTitle)
        val descriptionTextView: TextView = itemView.findViewById(R.id.textViewDescription)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)

        titleTextView.text = currentItem?.title
        descriptionTextView.text = currentItem?.description
        imageView.setImageResource(R.drawable.loop1) // Установите изображение по своему усмотрению

        return itemView
    }
    private var originalTasks: ArrayList<Task> = ArrayList()
    fun filter(query: CharSequence?) {
        query?.let {
            val filteredList = ArrayList<Task>()
            for (task in originalTasks) {
                if (task.title.contains(query, ignoreCase = true)) {
                    filteredList.add(task)
                }
            }
            clear()
            addAll(filteredList)
            notifyDataSetChanged()
        }
    }


}
