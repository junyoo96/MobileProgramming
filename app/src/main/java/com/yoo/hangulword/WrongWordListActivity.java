package com.yoo.hangulword;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class WrongWordListActivity extends AppCompatActivity{

    ArrayList<Word> wordList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrongwordlist);

        Intent intent=getIntent();
        //데이터 인텐트로 받아옴
        wordList=intent.getParcelableArrayListExtra("wordList");



        //load_values();
    }
}
