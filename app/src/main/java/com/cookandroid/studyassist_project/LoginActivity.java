package com.cookandroid.studyassist_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText edt_name, edt_password;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edt_name = findViewById(R.id.edt_name);
        edt_password = findViewById(R.id.edt_password);
        btn_login = findViewById(R.id.btn_login);


        // 로그인 버튼을 눌렀을때 -> 실행 구문
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edt_name.getText().toString();
                String password = edt_password.getText().toString();
                if (name.equals("") || password.equals(""))
                {
                    Toast.makeText(getApplicationContext(),
                            "사용자 비밀번호를 입력하세요.",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    intent.putExtra("name", name);
                    startActivityForResult(intent, 1);
                }
           }
        });
    }
}