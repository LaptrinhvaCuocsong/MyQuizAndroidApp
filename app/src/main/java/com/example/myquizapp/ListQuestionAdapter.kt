package com.example.myquizapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat

class ListQuestionAdapter(private val context: Context,
                          private val answers: List<String>): BaseAdapter() {
    var indexSelected = -1

    override fun getCount(): Int {
        return answers.size
    }

    override fun getItem(position: Int): Any {
        return answers[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView: View? = convertView
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.answer_item_view, parent, false)
        }
        val textView = convertView!!.findViewById(R.id.tvAnswer) as TextView
        val answer = answers[position]
        textView.text = answer
        val isSelected = indexSelected == position
        if (isSelected) {
            textView.setTextColor(ContextCompat.getColor(context, R.color.blue))
        } else {
            textView.setTextColor(ContextCompat.getColor(context, R.color.black))
        }
        return convertView!!
    }

}