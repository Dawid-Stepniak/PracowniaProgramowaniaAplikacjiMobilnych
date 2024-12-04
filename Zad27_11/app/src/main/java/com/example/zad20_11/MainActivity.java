package com.example.zad20_11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private Button acceptBtn;
    private TextView message;
    private EditText password;
    private EditText password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        email = findViewById(R.id.email);
        acceptBtn = findViewById(R.id.acceptBtn);
        message = findViewById(R.id.message);
        password = findViewById(R.id.password);
        password2 = findViewById(R.id.password2);
    }

    public void checkEmail(View view){
        String emailText = email.getText().toString();
        String passwordText = password.getText().toString();
        String password2Text = password2.getText().toString();
        Boolean emailCorrect = true;
        Boolean samePasswords = true;
        Boolean passwordCorrect = true;





        boolean hasDigit=false, hasUpperCase = false, hasLowerCase=false;

        for(char c:passwordText.toCharArray()){
            if(Character.isDigit(c)){
                hasDigit = true;
            }
            else if(Character.isUpperCase(c)){
                hasUpperCase = true;
            }
            else if(Character.isLowerCase(c)){
                hasLowerCase = true;
            }

        }
        if(!hasDigit || !hasUpperCase || !hasLowerCase || passwordText.length()<8){
            passwordCorrect = false;
            message.setText("Hasło musi mieć min. 8 znaków i zawierać min. jedną liczbę, małą literę i wielką literę");
        }




        if(!passwordText.equals(password2Text)){
            message.setText("Hasła się różnią");
            samePasswords = false;
        }
        else{
            samePasswords = true;
        }

        String emailPattern = "^.*@.*$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(emailText);

        if(!matcher.matches()){
            message.setText("Nieprawidłowy adres email");
            emailCorrect = false;
        }
        else{
            emailCorrect = true;
        }



        if(emailCorrect && passwordCorrect && matcher.matches()){
            message.setText("Witaj " + emailText);
            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
            intent.putExtra("user_email",emailText);
            startActivity(intent);
        }


    }

}