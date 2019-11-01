package com.example.lab3

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment


class ExitDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
        builder.setTitle(R.string.exit_dialog_title)
        builder.setMessage(R.string.exit_dialog_message)
            .setPositiveButton(
                R.string.exit_dialog_ok, { dialogInterface: DialogInterface, i: Int ->
                    activity?.finishAffinity()
                })
            .setNegativeButton(
                R.string.exit_dialog_cancel, { dialogInterface: DialogInterface, i: Int ->
                    dismiss()
                })
        return builder.create()
    }
}