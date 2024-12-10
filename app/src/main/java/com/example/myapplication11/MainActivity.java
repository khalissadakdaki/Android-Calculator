package com.example.myapplication11;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    TextView tvLogin;
    Button btnLogin,btn7;
    EditText etLogin;

    String login;
    ImageView eye;
    EditText pass;


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


        tvLogin = findViewById(R.id.tvLogin);
        btnLogin = findViewById(R.id.btnLogin);
        etLogin= findViewById(R.id.etLogin);
        btn7=findViewById(R.id.btn6);
        eye=findViewById(R.id.eye);
        pass=findViewById(R.id.pass);
        pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        eye.setImageResource(R.drawable.im_eye);
        btnLogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              login=etLogin.getText().toString();
               String passwordInput = pass.getText().toString().trim();
               String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,}$";
              if(login.length()!=0){
                  Toast.makeText(MainActivity.this,"bonjour\t"+login, Toast.LENGTH_LONG).show();
              }else{
                  Toast.makeText(MainActivity.this,"empty login",Toast.LENGTH_LONG).show();
              }
               if(passwordInput.isEmpty()) {
                   pass.setError("Le mot de passe ne peut pas être vide");
               } else if (!passwordInput.matches(passwordPattern)) {
                   pass.setError("Le mot de passe doit contenir au moins 8 caractères, un chiffre, une majuscule et un caractère spécial");
               } else {
                   // Mot de passe valide
                   Toast.makeText(getApplicationContext(), "Mot de passe valide", Toast.LENGTH_SHORT).show();
               }
           }
       });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }

        });
        eye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Vérifier si le mot de passe est actuellement masqué
                if (pass.getInputType() == (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD)) {
                    // Changer en mode texte visible
                    pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
                    eye.setImageResource(R.drawable.im_eye);  // Icône d'œil ouvert
                } else {
                    // Changer en mode texte masqué
                    pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    eye.setImageResource(R.drawable.im_eye);  // Icône d'œil fermé
                }

                // Replacer le curseur à la fin du texte (optionnel)
                pass.setSelection(pass.length());
            }
        });





    }
}