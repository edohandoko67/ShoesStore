package com.example.frontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText email, pass;
    ImageView btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin2);
        btnLogin.setOnClickListener(v->{
            login();
        });
    }

    private void login() {
        String username = email.getText().toString().trim();
        String password = pass.getText().toString().trim();

        if (TextUtils.isEmpty(username)){
            Toast.makeText(this, "Username harus diisi", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Password harus diisi", Toast.LENGTH_SHORT).show();
            return;
        }
        if (username.equals("admin") || password.equals("admin00")){
            Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MenuActivity.class));
        }else {
            Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show();
        }
    }
}