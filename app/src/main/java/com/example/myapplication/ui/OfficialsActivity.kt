package com.example.myapplication.ui

import android.content.res.ColorStateList
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.model.Politicians
import com.google.gson.Gson
import kotlinx.android.synthetic.main.rating_popup.*

class OfficialsActivity : AppCompatActivity(), RatingBar.OnRatingBarChangeListener {

    private val TAG = "OfficialsActivity"
    private var rating:Float = 0F

    lateinit var rBar:RatingBar
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.official_profile)
        Log.d(TAG, "onCreate: started.")

        // initialising views from the layout files
        val imgbtn = findViewById<ImageButton>(R.id.info_icon)
        val ratingPopOp = findViewById<Button>(R.id.btnSubmitRating)
        val imageView = findViewById<ImageView>(R.id.profile_img)
        val tallyScorePercentage = findViewById<TextView>(R.id.allyScorePercentage)
        val politiciansName = findViewById<TextView>(R.id.legislativeName)
        val lagistiveOffice = findViewById<TextView>(R.id.legislativeOffice)
         rBar = findViewById(R.id.ratingBar1)

        // converting the politician parcelable back to an object
        val gson = Gson()
        val politicians = gson.fromJson(intent.getStringExtra("identifier"), Politicians::class.java)

        // loading the politician image image with Glide
        val politicianImageUrl: String = politicians.image
        Glide.with(this)
            .load(politicianImageUrl)
            .into(imageView)

        // setting the tallyScore
        tallyScorePercentage.text = politicians.percentageScore

        //setting the politicain Name
        politiciansName.text = politicians.names

        // setting the politician Legislative Office
        lagistiveOffice.text = politicians.position

        // on click of the start rating button the rating dialog is displayed
        ratingPopOp.setOnClickListener {
            showRatingBar()
        }

        imgbtn.setOnClickListener {
            showCustomAlert()
        }

        rBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            if (rating > 0){
                ratingPopOp.text = "UPDATE"
                ratingPopOp.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.white))
                ratingPopOp.setTextColor(resources.getColor(R.color.black))
            }
        }
    }

    private fun showCustomAlert() {
        val dialogView = layoutInflater.inflate(R.layout.ally_score_desc_popup, null)
        val customDialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .show()
        val btDismiss = dialogView.findViewById<ImageView>(R.id.closewindow1)
        val btDismiss1 = dialogView.findViewById<Button>(R.id.btnCloseAlyScoreDesc)
        btDismiss.setOnClickListener {
            customDialog.dismiss()
        }
        btDismiss1.setOnClickListener {
            customDialog.dismiss()
        }
    }

    /**
     * Displays the rating dialog
     * on click of submit the total rating is calculated and a
     * total rating dialog is displayed
     */
    private fun showRatingBar() {
        val dialogView = layoutInflater.inflate(R.layout.rating_popup, null)
        val customDialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .show()
        val closeButton1 = dialogView.findViewById<ImageView>(R.id.closewindow1)
        val cancelButton = dialogView.findViewById<Button>(R.id.official_activity_cancelButton)
        closeButton1.setOnClickListener {
            customDialog.dismiss()
        }
        cancelButton.setOnClickListener {
            customDialog.cancel()
        }

//        val sharedPreference = getSharedPreferences("numStars", MODE_PRIVATE)
        val rBar1 = dialogView.findViewById<RatingBar>(R.id.ratingtxt1)
        val rBar2 = dialogView.findViewById<RatingBar>(R.id.ratingtxt2)
        val rBar3 = dialogView.findViewById<RatingBar>(R.id.ratingtxt3)
        val rBar4 = dialogView.findViewById<RatingBar>(R.id.ratingtxt4)
        val rBar5 = dialogView.findViewById<RatingBar>(R.id.ratingtxt5)
        val rBar = dialogView.findViewById<RatingBar>(R.id.ratingBar1)

            val submitRatingButton = dialogView.findViewById<Button>(R.id.submitButton)
            submitRatingButton?.setOnClickListener {
                val msg1 = rBar1.rating.toString().toFloat()
                val msg2 = rBar2.rating.toString().toFloat()
                val msg3 = rBar3.rating.toString().toFloat()
                val msg4 = rBar4.rating.toString().toFloat()
                val msg5 = rBar5.rating.toString().toFloat()

                    // calculating the total users rating score
                   val totalRating =  (msg1 + msg2 + msg3 + msg4 + msg5)/5

                customDialog.dismiss()
                successRatingDialog(totalRating)
        }

    }

    private fun onRatingChanged() {
        ratingtxt1
        ratingtxt2
        ratingtxt3
        ratingtxt4
        ratingtxt5
    }

    /**
     * displays a successfull rating dialog to show the user the total rating
     */
    private fun successRatingDialog(rating: Float) {
        val successRatingDialogView = layoutInflater.inflate(R.layout.rating_success, null)
        var ratingBar: RatingBar = successRatingDialogView.findViewById<RatingBar>(R.id.ratingBar)
        ratingBar.rating = rating
        rBar.rating = rating
        val successDialog = AlertDialog.Builder(this)
            .setView(successRatingDialogView)
            .show()
        val closeButton = successRatingDialogView.findViewById<Button>(R.id.official_activity_cancelButton)
        val cancelButton = successRatingDialogView.findViewById<ImageView>(R.id.official_activity_Button_close2)
        closeButton.setOnClickListener {
            successDialog.dismiss()
        }
        cancelButton.setOnClickListener {
            successDialog.dismiss()
        }

    }

    override fun onRatingChanged(ratingBar: RatingBar?, rating: Float, fromUser: Boolean) {

    }

}