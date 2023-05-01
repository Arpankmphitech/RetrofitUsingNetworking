package com.example.retrofitusingnetworking.bottom_sheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.retrofitusingnetworking.R
import com.google.android.material.bottomsheet.BottomSheetDialog


class BottomSheetActivity : AppCompatActivity() {

    var btnShow: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet)

        initView()

    }

    private fun initView() {
        btnShow = findViewById(R.id.btnShow)

        btnShow!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val bottomSheetDialog = BottomSheetDialog(
                    this@BottomSheetActivity, R.style.BottomSheet
                )
                val bottomSheet: View = LayoutInflater.from(applicationContext)
                    .inflate(
                        R.layout.bottom_sheet_layout,
                        findViewById<View>(R.id.bottomSheetCont) as LinearLayout
                    )
                bottomSheet.findViewById<ConstraintLayout>(R.id.contLayoutOne)
                    .setOnClickListener(object : View.OnClickListener {
                        override fun onClick(v: View?) {
                            Toast.makeText(this@BottomSheetActivity, "option 1", Toast.LENGTH_SHORT).show()
                            bottomSheetDialog.dismiss()
                        }
                    })
                bottomSheet.findViewById<ConstraintLayout>(R.id.contLayoutTwo)
                    .setOnClickListener(object : View.OnClickListener {
                        override fun onClick(v: View?) {
                            Toast.makeText(this@BottomSheetActivity, "option 2", Toast.LENGTH_SHORT).show()
                            bottomSheetDialog.dismiss()
                        }
                    })
                bottomSheet.findViewById<ConstraintLayout>(R.id.contLayoutThree)
                    .setOnClickListener(object : View.OnClickListener {
                        override fun onClick(v: View?) {
                            Toast.makeText(this@BottomSheetActivity, "option 3", Toast.LENGTH_SHORT).show()
                            bottomSheetDialog.dismiss()
                        }
                    })
                bottomSheet.findViewById<ConstraintLayout>(R.id.contLayoutFour)
                    .setOnClickListener(object : View.OnClickListener {
                        override fun onClick(v: View?) {
                            Toast.makeText(this@BottomSheetActivity, "option 4", Toast.LENGTH_SHORT).show()
                            bottomSheetDialog.dismiss()
                        }
                    })
                bottomSheet.findViewById<ConstraintLayout>(R.id.contLayoutFive)
                    .setOnClickListener(object : View.OnClickListener{
                        override fun onClick(v: View?) {
                            Toast.makeText(this@BottomSheetActivity, "option 5", Toast.LENGTH_SHORT).show()
                            bottomSheetDialog.dismiss()
                        }
                    })
                bottomSheetDialog.setContentView(bottomSheet)
                bottomSheetDialog.show()
            }
        })

    }
}