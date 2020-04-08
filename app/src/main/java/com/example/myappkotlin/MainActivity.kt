package com.example.myappkotlin

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.InputType
import android.view.*
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.btn_Dialog).setOnClickListener { v ->
            val builder = AlertDialog.Builder(this@MainActivity)
            val viewGroup = findViewById<ViewGroup>(android.R.id.content)
            val dialogView = LayoutInflater.from(v.context).inflate(R.layout.custom_dialog, viewGroup, false)
            val editText = dialogView.findViewById<View>(R.id.editText) as EditText
            val keyboard: MyKeyboard = dialogView.findViewById<View>(R.id.keyboard) as MyKeyboard
            editText.setRawInputType(InputType.TYPE_CLASS_TEXT)
            editText.setTextIsSelectable(true)
            val ic = editText.onCreateInputConnection(EditorInfo())
            keyboard.setInputConnection(ic)
            editText.requestFocus()
            editText.showSoftInputOnFocus = false
            builder.setView(dialogView)
            val alertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.setCanceledOnTouchOutside(false)
            alertDialog.show()
            alertDialog.window!!.setGravity(Gravity.BOTTOM)
            alertDialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
            alertDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            val btn = dialogView.findViewById<View>(R.id.tv_cancel) as TextView
            btn.setOnClickListener {
                // TODO Auto-generated method stub
                //DO you work here
                alertDialog.dismiss()
            }
        }
    }
}
