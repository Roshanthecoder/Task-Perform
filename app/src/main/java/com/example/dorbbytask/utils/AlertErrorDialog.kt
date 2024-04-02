package com.example.dorbbytask.utils

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.example.dorbbytask.R

object AlertErrorDialog {


    fun showErrorDialog(context: Context, message: String) {
        AlertDialog.Builder(context)
            .setTitle(context.getString(R.string.error))
            .setMessage(message)
            .setPositiveButton(context.getString(R.string.ok), null)
            .show()
    }
}