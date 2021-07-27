package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.rating_popup.*

class OfficialsActivity : AppCompatActivity(), RatingBar.OnRatingBarChangeListener {
    private val TAG = "OfficialsActivity"

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.official_profile)
        Log.d(TAG, "onCreate: started.");
        val imgbtn = findViewById<ImageButton>(R.id.info_icon)
        val ratingPopOp = findViewById<Button>(R.id.btnSubmitRating)

        ratingPopOp.setOnClickListener {
            showRatingBar()
        }
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
        val sharedPreference = getSharedPreferences("numStars", MODE_PRIVATE)
        val rBar1 = findViewById<RatingBar>(R.id.ratingtxt1)
        val rBar2 = findViewById<RatingBar>(R.id.ratingtxt2)
        val rBar3 = findViewById<RatingBar>(R.id.ratingtxt3)
        val rBar4 = findViewById<RatingBar>(R.id.ratingtxt4)
        val rBar5 = findViewById<RatingBar>(R.id.ratingtxt5)
        val rBar = findViewById<RatingBar>(R.id.ratingBar1)
        if (rBar != null) {
            val submitRatingButton = findViewById<Button>(R.id.submitButton)
            submitRatingButton?.setOnClickListener {
                val msg1 = rBar1.rating.toString().toFloat()
                val msg2 = rBar2.rating.toString().toFloat()
                val msg3 = rBar3.rating.toString().toFloat()
                val msg4 = rBar4.rating.toString().toFloat()
                val msg5 = rBar5.rating.toString().toFloat()



                val msg = ((msg2 + msg3 + msg4 + msg5) / 5)
                val msgRating = msg.toFloat()
                rBar.setRating(msgRating)
            }
        }

    }

    private fun onRatingChanged() {
        ratingtxt1
        ratingtxt2
        ratingtxt3
        ratingtxt4
        ratingtxt5
    }

    override fun onRatingChanged(ratingBar: RatingBar?, rating: Float, fromUser: Boolean) {
        TODO("Not yet implemented")
    }
}