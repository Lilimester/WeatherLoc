package com.weatherloc.jkp_eval_rs.Utils

import android.app.AlertDialog
import android.content.Context

class InfoDialog {
    companion object{
        fun show(context: Context, title:String, message:String){
            AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("Ok",null)
                .show()
        }
    }
}