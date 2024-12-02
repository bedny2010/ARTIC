package com.example.artic

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.artic.db.MyDbManager

class LogInActivity : AppCompatActivity() {

    private lateinit var myDbManager: MyDbManager


    private lateinit var userLogin: EditText
    private lateinit var userEmail: EditText
    private lateinit var userPass: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        // Инициализируем переменные
        userLogin = findViewById(R.id.ed_username)
        userEmail = findViewById(R.id.ed_email)
        userPass = findViewById(R.id.ed_password)

        val button: Button = findViewById(R.id.btn_register)
        val LinkToSign: TextView = findViewById(R.id.link_to_sign)
        myDbManager = MyDbManager(this)



        LinkToSign.setOnClickListener {
            val intent = Intent(this, SignActivity::class.java)
            startActivity(intent)
        }
    }

    fun onClickRegistration(view: View?) {
        val login = userLogin.text.toString().trim()
        val email = userEmail.text.toString().trim()
        val pass = userPass.text.toString().trim()

        if (login.isEmpty() || email.isEmpty() || pass.isEmpty()) {
            Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_SHORT).show()
        } else {
            myDbManager.openDb()
            myDbManager.insertToDb(login, email, pass)
            Toast.makeText(this, "Вы успешно зарегестрированы", Toast.LENGTH_SHORT).show()

            userLogin.text.clear()
            userEmail.text.clear()
            userPass.text.clear()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()
    }

}
