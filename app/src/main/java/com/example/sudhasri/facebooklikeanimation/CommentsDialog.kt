package com.example.sudhasri.facebooklikeanimation

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import kotlinx.android.synthetic.main.dialog_comments.view.*
import kotlinx.android.synthetic.main.item_view.view.*

class CommentsDialog : DialogFragment(){
    var comments: List<String> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        comments = resources.getStringArray(R.array.comments).toList()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.dialog_comments, container, false)

        comments.forEach {comment ->
            val rowView = inflater.inflate(R.layout.item_view, rootView.row_container, false)
            rowView.text.text = comment
            rootView.row_container.addView(rowView)
        }

        rootView.cross_img.setOnClickListener {
            dismiss()
        }
        return rootView
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }


}