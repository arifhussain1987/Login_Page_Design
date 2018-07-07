package com.example.arifa.login_page_design;

import android.graphics.Color;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // this is for validation purpose
    private TextInputLayout txtuname, txtpass;
    // this is for onTextChanged event purpose
    private EditText txtuser, txtpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtuname = findViewById(R.id.txtusername);
        txtpass = findViewById(R.id.txtpassword);

        txtuser = (EditText) findViewById(R.id.txtuname);
        txtpassword = (EditText) findViewById(R.id.txtpass);

        txtuser.addTextChangedListener(loginwatcher);
        txtpassword.addTextChangedListener(loginwatcher);
    }


    private TextWatcher loginwatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String usertext = txtuser.getText().toString().trim();
            String passtext = txtpassword.getText().toString().trim();

            Button btnsignin = (Button) findViewById(R.id.btnsignin);

            if(usertext.isEmpty() | passtext.isEmpty())
            {
                btnsignin.setEnabled(false);
                btnsignin.setBackgroundColor(Color.parseColor("#D3D3D3"));
                btnsignin.setTextColor(Color.parseColor("#2F4F4F"));
            }
            else
            {
                btnsignin.setBackgroundColor(Color.parseColor("#34e89e"));
                btnsignin.setTextColor(Color.parseColor("#ffffff"));
                btnsignin.setEnabled(true);
            }

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };



    private boolean validateUsername()
    {
        String username = txtuname.getEditText().getText().toString().trim();
        if(username.isEmpty())
        {
            txtuname.setError("Please provide username");
            return false;
        }
        else if (username.length() > 10)
        {
            txtuname.setError("Username should not exceed 10 characters");
            return false;
        }
        else {
            txtuname.setError(null);
            return true;
        }
    }


    private boolean validatePassword()
    {
        String password = txtpass.getEditText().getText().toString().trim();

        if(password.isEmpty())
        {
            txtpass.setError("Please provide password");
            return false;
        }
        else {
            txtpass.setError(null);
            return true;
        }
    }

    public void login(View view)
    {
        if(!validateUsername() | !validatePassword())
        {
            Toast.makeText(this, "Something wrong", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();
        }

    }


}
