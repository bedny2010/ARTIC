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

class SignActivity : AppCompatActivity() {
    private lateinit var myDbManager: MyDbManager
    private lateinit var userLogin: EditText
    private lateinit var userPass: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)

        userLogin = findViewById(R.id.ed_username_sign)
        userPass = findViewById(R.id.ed_password_sign)
        val button: Button = findViewById(R.id.btn_sign)
        val linkToReg: TextView = findViewById(R.id.link_to_reg)

        // Инициализация myDbManager
        myDbManager = MyDbManager(applicationContext)

        linkToReg.setOnClickListener {
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener {
            onClickSign(it)
        }
    }

    fun onClickSign(view: View?) {
        val login = userLogin.text.toString().trim()
        val pass = userPass.text.toString().trim()

        if (login.isEmpty() || pass.isEmpty()) {
            Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_SHORT).show()
        } else {
            val user = myDbManager.getUser(login, pass)
            if (user != null) {
                Toast.makeText(this, "Добро пожаловать, ${user.nickname}", Toast.LENGTH_LONG).show()
                userLogin.text.clear()
                userPass.text.clear()

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Пользователь не авторизован", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

