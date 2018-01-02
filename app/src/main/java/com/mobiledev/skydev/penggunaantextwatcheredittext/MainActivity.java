package com.mobiledev.skydev.penggunaantextwatcheredittext;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText1, editText2;
    String text1, text2;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("User Login Sederhana");
        getSupportActionBar().setSubtitle("mobiledev-id.com");
        editText1 = (EditText) findViewById(R.id.edittext_username);
        editText2 = (EditText) findViewById(R.id.edittext_password);
        textView = (TextView) findViewById(R.id.hintpassword);
        textView.setVisibility(View.GONE);
        //menset textview dalam keadaan dihilangkan (bukan tidak terlihat seperti (View.INVISIBLE)

        editText2.addTextChangedListener(inputPasswordWatcher);
        //memanggil addTextChangelistener dari TextWatcher

    }

    private final TextWatcher inputPasswordWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            //method ini  wajib ada meskipun disini kosong valuenya
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            textView.setVisibility(View.VISIBLE);
            //menset textview dalam mode visible terlihat

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s.length()== 0){
                textView.setVisibility(View.GONE);
                //jika panjang atau jumlah text dari variable s tidak ada atau 0 maka
                //menset textview dalam keadaan dihilangkan (bukan tidak terlihat seperti (View.INVISIBLE)
            }
            else {


                textView.setText("Password kalian : "+editText2.getText());
                //atau jika  tidak maka akan terlihat dan menampilkan text password kalian
                //berdasarkan inputan pada object ediText 2 di bagian password

            }



        }
    };


    public void loginMasuk(View view) {
        //Method onClick pada Button

        text1 = editText1.getText().toString();
        text2 = editText2.getText().toString();

        //Kondisi jika username dan password benar maka akan menampilkan pesan text toast
        //Login sukses dan masuk ke activity 2
        if ((text1.contains("Username")) && ((text2.contains("Password")))) {
            Toast.makeText(this, "Login Sukses", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        } else if ((text1.matches("") || text2.matches("")))
          /*
          Atau jika input text 1 dan text 2 kosong
           */ {
            //Maka akan menampilkan pesan text toast
            Toast.makeText(this, "Isikan Username dan Password", Toast.LENGTH_SHORT).show();

        } else {
            //jika kedua kondisi diatas tidak memenuhi

            Toast.makeText(this, "Login Gagal /Username Password Salah", Toast.LENGTH_SHORT).show();
        }

    }


}