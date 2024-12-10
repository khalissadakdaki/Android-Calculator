package com.example.myapplication11;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {
 Button btnback,btnsite,btncamera,btncall;
 Intent intent1,intent2,intent3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnback=findViewById(R.id.btnback);
        btnsite=findViewById(R.id.btnsite);
        btncamera=findViewById(R.id.btncamera);
        btncall=findViewById(R.id.btncall);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }

        });
        btnsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="https://www.ensaf.ac.ma";
                intent1 =new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent1);
            }

        });
        btncamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);


                if (intent2.resolveActivity(getPackageManager()) != null) {


                    startActivity(intent2);
                } else {

                    Toast.makeText(getApplicationContext(), "Pas de caméra disponible", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse("tel:0773569360");
                intent3 =new Intent(Intent.ACTION_CALL, uri);
                startActivity(intent3);
            }

        });

    }
}