package com.yoo.hangulword;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class WordToMeaningActivity extends AppCompatActivity {

    TextView wrongTimes;
    TextView word;
    TextView meaningone;
    TextView meaningtwo;
    TextView meaningthree;

    TextView wrongSign;

    LinearLayout layoutone;
    LinearLayout layouttwo;
    LinearLayout layoutthree;

    ArrayList<Word> wordList;

    int questionCount=0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wordtomeaning);

        wrongTimes=(TextView)findViewById(R.id.wordtomeaning_wrongtimes);
        word=(TextView)findViewById(R.id.wordtomeaning_word);
        meaningone=(TextView)findViewById(R.id.wordtomeaning_meaningone);
        meaningtwo=(TextView)findViewById(R.id.wordtomeaning_meaningtwo);
        meaningthree=(TextView)findViewById(R.id.wordtomeaning_meaningthree);

        wrongSign=(TextView)findViewById(R.id.wrongsign);

        layoutone = (LinearLayout) findViewById (R.id.wordtomeaning_meaningLayoutOne);
        layouttwo = (LinearLayout) findViewById (R.id.wordtomeaning_meaningLayoutTwo);
        layoutthree = (LinearLayout) findViewById (R.id.wordtomeaning_meaningLayoutThree);

        Intent intent=getIntent();

        //데이터 인텐트로 받아옴
        wordList=intent.getParcelableArrayListExtra("wordList");

        wrongTimes.setText(wordList.get(0).getWrongTimes());
        word.setText(wordList.get(0).getWord());
        meaningone.setText(wordList.get(0).getMeaning());
        meaningtwo.setText(wordList.get(1).getMeaning());
        meaningthree.setText(wordList.get(2).getMeaning());



        layoutone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               ChangeWord();
                questionCount++;
            }
        });

        layouttwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangeWord();
                questionCount++;
            }
        });

        layoutthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              ChangeWord();
              questionCount++;
            }
        });

    }

    public void ChangeWord()
    {

        if(questionCount==1)
        {
            wrongSign.setText("WRONG");

        }
        else
        {
            wrongSign.setText("");
            wrongTimes.setText(wordList.get(questionCount+1).getWrongTimes());
            word.setText(wordList.get(questionCount+1).getWord());
            meaningone.setText(wordList.get((int)(Math.random()*(wordList.size()-1))).getMeaning());
            meaningtwo.setText(wordList.get((int)(Math.random()*(wordList.size()-1))).getMeaning());
            meaningthree.setText(wordList.get((int)(Math.random()*(wordList.size()-1))).getMeaning());
        }


    }

    //맞었는지 틀렸는지 체크하고 right wrong써주는 함수

}
