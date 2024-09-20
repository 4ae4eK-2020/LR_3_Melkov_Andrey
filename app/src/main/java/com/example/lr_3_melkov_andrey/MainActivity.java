package com.example.lr_3_melkov_andrey;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button button_1, button_2, button_3, button_4;
    String[] weaponMasters = {"Hu Tao", "Furine", "Lumine"};

    @SuppressLint("MissingInflatedId")
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

        button_1 = findViewById(R.id.button_1);
        button_2 = findViewById(R.id.button_2);
        button_3 = findViewById(R.id.button_3);
        button_4 = findViewById(R.id.button_4);

        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "кнопка номер 1 нажата", Toast.LENGTH_SHORT).show();
            }
        });

        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "кнопка номер 2 нажата", Toast.LENGTH_LONG).show();
            }
        });

        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("кнопка 3")
                        .setIcon(R.drawable.test_icon)
                        .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(), "Диалоговое окно закрыто", Toast.LENGTH_SHORT).show();
                                dialogInterface.cancel();
                            }
                        })
                        .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                button_1.setTextColor(Color.parseColor("#FF0000"));
                                button_2.setTextColor(Color.parseColor("#FF0000"));
                                button_3.setTextColor(Color.parseColor("#FF0000"));
                                button_4.setTextColor(Color.parseColor("#FF0000"));
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("Кто из героев является копейщицей?")
                        .setSingleChoiceItems(weaponMasters, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if(i == 0) {
                                    Toast.makeText(getApplicationContext(), "Верно", Toast.LENGTH_SHORT).show();
                                } else {
                                    button_1.setVisibility(View.INVISIBLE);
                                    button_2.setVisibility(View.INVISIBLE);
                                    button_3.setVisibility(View.INVISIBLE);
                                    button_4.setVisibility(View.INVISIBLE);
                                }
                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}