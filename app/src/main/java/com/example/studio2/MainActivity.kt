package com.example.studio2

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val ENTER_BALANCE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun changeActivity(view: View) {
        val changeActivity = Intent(this,ChangeActivity::class.java)
        startActivityForResult(changeActivity, ENTER_BALANCE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==ENTER_BALANCE) {
            if(resultCode== Activity.RESULT_OK) {
                val balance = data?.extras?.getString("balance")
                value_display.text = "Balance is: " + balance
            }
        }
    }
    fun returnBalance(view: View) {
        val inputBalance = value_display.text.toString()
        var result = Intent()
        result.putExtra("balance", inputBalance)
        setResult(Activity.RESULT_OK, result)
        finish()
    }
}
