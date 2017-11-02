package com.example.d2j_00.uts_a11201508751;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {
    private RecyclerView mRecycleView;
    private SharedPreferences mPreferences;
    private ChatAdapter mAdapter;
    private List<Chat> mData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mPreferences.registerOnSharedPreferenceChangeListener(this);
        loadSharedPreferences();
    }
    private void initView(){
        mRecycleView = (RecyclerView) findViewById(R.id.mRecycleView);
        LinearLayoutManager lm = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecycleView.setLayoutManager(lm);
        mRecycleView.setHasFixedSize(true);

    }
    private void loadSharedPreferences(){
        String dataChat =mPreferences.getString(AddChatActivity.DATA_CHAT,"");
        mData = new ArrayList<>();
        if(!dataChat.isEmpty()){
            String jsonChat = mPreferences.getString(AddChatActivity.DATA_CHAT,"");
            Gson gson = new Gson();
            ArrayList<Chat> data = gson.fromJson(jsonChat,
                    new TypeToken<ArrayList<Chat>>() {
                    }.getType());
            mData.addAll(data);
        }
        DividerItemDecoration decoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        mRecycleView.addItemDecoration(decoration);
        mAdapter = new ChatAdapter(mData);
        mRecycleView.setAdapter(mAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if(key.equals(AddChatActivity.ADD_CHAT)){
            String jsonChat = sharedPreferences.getString(AddChatActivity.ADD_CHAT,"");
            if(!jsonChat.isEmpty()){
                Gson gson = new Gson();
                Chat chat = gson.fromJson(jsonChat,
                        new TypeToken<Chat>() {
                        }.getType());
                putGson(chat);
                mAdapter.notifyItemInserted(mData.size()-1);
                sharedPreferences.edit().remove(AddChatActivity.ADD_CHAT).apply();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPreferences.unregisterOnSharedPreferenceChangeListener(this);

    }
    private void putGson(Chat chat){
        Gson gson = new Gson();
        mData.add(chat);
        String jsonString = gson.toJson(mData);
        mPreferences.edit().putString(AddChatActivity.DATA_CHAT,jsonString).apply();
    }
    public void chatActivity(View view){
        Intent intent = new Intent(this, AddChatActivity.class);
        startActivity(intent);
    }
}
