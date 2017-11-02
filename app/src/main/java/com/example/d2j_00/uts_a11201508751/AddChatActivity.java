package com.example.d2j_00.uts_a11201508751;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddChatActivity extends AppCompatActivity {

    public static final String ADD_CHAT = "add_chat";
    public static final String DATA_CHAT = "data_chat";
    private EditText mPengirim;
    private EditText mPesan;
    private Toast mToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chat);
        initView();
    }
    private void initView(){
        mPengirim = (EditText) findViewById(R.id.mPengirim);
        mPesan = (EditText) findViewById(R.id.mPesan);
    }
    public void addChat(View view){
        hideSoftKeyboard(view);
        String pengirim = mPengirim.getText().toString();
        String pesan = mPesan.getText().toString();
        if(pengirim.isEmpty() || pesan.isEmpty()){
            if(mToast != null){
                mToast.cancel();
            }
            mToast = Toast.makeText(this,"Pengguna/Pesan masih kosong",Toast.LENGTH_SHORT);
            mToast.show();
        }
        else {
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(" EEE dd-MMM-yy HH:mm");
            String tanggal = simpleDateFormat.format(new Date());
            Gson gson = new Gson();
            Chat chat = new Chat(pengirim,pesan,tanggal,0);
            String jsonString = gson.toJson(chat);
            sp.edit().putString(ADD_CHAT,jsonString).apply();
            finish();

        }
    }
    private void hideSoftKeyboard(View view) {
        InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
