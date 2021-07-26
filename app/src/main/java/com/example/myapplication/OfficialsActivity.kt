package com.example.myapplication

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.rating_popup.*

class OfficialsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.official_profile)
        val imgbtn = findViewById<ImageButton>(R.id.info_icon)
        imgbtn.setOnClickListener {
            showCustomAlert()

        }


    }

    private fun showCustomAlert() {
        val dialogView = layoutInflater.inflate(R.layout.ally_score_desc_popup, null)
        val customDialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .show()
        val btDismiss = dialogView.findViewById<Button>(R.id.closewindow1)
        val btDismiss1 = dialogView.findViewById<Button>(R.id.btnCloseAlyScoreDesc)
        btDismiss.setOnClickListener {
            customDialog.dismiss()
        }
        btDismiss1.setOnClickListener {
            customDialog.dismiss()
        }
    }

    private fun showRatingBar() {
        val dialogView = layoutInflater.inflate(R.layout.rating_popup, null)
        val customDialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .show()
        val closeButton1 = dialogView.findViewById<Button>(R.id.closewindow1)
        val cancelButton = dialogView.findViewById<Button>(R.id.cancelButton)
        closeButton1.setOnClickListener {
            customDialog.dismiss()
        }
        cancelButton.setOnClickListener {
            customDialog.cancel()
        }

    }

    private fun onRatingChanged() {
        ratingtxt1
        ratingtxt2
        ratingtxt3
        ratingtxt4
        ratingtxt5
    }
}