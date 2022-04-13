package com.example.bloodpair

import android.app.Activity
import androidx.appcompat.app.AlertDialog
import bloodpair.R

class LoadingDialog{
    private lateinit var alertDialog: AlertDialog
    private lateinit var activity: Activity

    constructor(activity: Activity) {
        this.activity = activity
    }

    fun startDialog(){
        var builder = AlertDialog.Builder(activity)
        var inflater = activity.layoutInflater
        builder.setView(inflater.inflate(R.layout.loading, null))
        builder.setCancelable(true)

        alertDialog = builder.create()
        alertDialog.show()
    }

    fun dismissDialog(){
        alertDialog.dismiss()
    }
}