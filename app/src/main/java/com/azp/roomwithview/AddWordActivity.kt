package com.azp.roomwithview

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_add_word.*

class AddWordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_word)

        btnSave.setOnClickListener {
            val replyIntent = Intent()
            if(TextUtils.isEmpty(txtWord.text)){
                txtWord.setError("Please fill the word")
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val word: String = txtWord.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, word)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "REPLY_DATA"
    }

}
