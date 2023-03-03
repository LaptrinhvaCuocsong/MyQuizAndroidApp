package com.example.myquizapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListQuestionAdapter(private val context: Context,
                          private val questions: List<QuestionModel>): BaseAdapter() {
    override fun getCount(): Int {
        return questions.size
    }

    override fun getItem(position: Int): Any {
        return questions[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView: View? = convertView
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.answer_item_view, parent, false)
            val textView = convertView!!.findViewById(R.id.tvAnswer) as TextView
            textView.text = ""
        }
        return convertView!!
    }

}