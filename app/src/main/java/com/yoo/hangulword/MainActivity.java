package com.yoo.hangulword;

import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //static ContactDBHelper dbHelper = null ;
    SQLiteDatabase sampleDB=null;
    private final String dbName = "webnautes";
    private final String tableName = "words";

    //db내용 담을곳
    private ArrayList<Word> wordList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("디비","디비1");

        try {


            sampleDB = this.openOrCreateDatabase(dbName, MODE_PRIVATE, null);

            //테이블이 존재하지 않으면 새로 생성합니다.
//            sampleDB.execSQL("CREATE TABLE IF NOT EXISTS " + tableName
//                    + " (name VARCHAR(20), phone VARCHAR(20) );");

            //테이블이 존재하지 않으면 새로 생성합니다.
            sampleDB.execSQL("CREATE TABLE IF NOT EXISTS " + tableName
                    + " (wordNum INT, word VARCHAR(100), meaning VARCHAR(100), wrongtimes INT );");

            //테이블이 존재하는 경우 기존 데이터를 지우기 위해서 사용합니다.
            sampleDB.execSQL("DELETE FROM " + tableName  );


            //새로운 데이터를 테이블에 집어넣습니다..
//            for (int i=0; i<5; i++ ) {
//                sampleDB.execSQL("INSERT INTO " + tableName
//                        + " (name, phone)  Values ('" + "oh" + "', '" + "jejus" +"');");
//            }
            sampleDB.execSQL("INSERT INTO " + tableName
                    + " (wordNum,word,meaning,wrongtimes)  Values ('" + 1 + "', '" + "먹다" +"','" + "무언가를 섭취하다" + "','" + 0 + "');");
            sampleDB.execSQL("INSERT INTO " + tableName
                    + " (wordNum,word,meaning,wrongtimes)  Values ('" + 2 + "', '" + "고려하다" +"','" + "무언가를 하려 깊숙히 생각해보다" + "','" + 0 + "');");
            sampleDB.execSQL("INSERT INTO " + tableName
                    + " (wordNum,word,meaning,wrongtimes)  Values ('" + 3 + "', '" + "가다" +"','" + "어딘가 장소로 이동하다" + "','" + 0 + "');");
            sampleDB.execSQL("INSERT INTO " + tableName
                    + " (wordNum,word,meaning,wrongtimes)  Values ('" + 4 + "', '" + "눕다" +"','" + "몸을 땅에 붙히다" + "','" + 0 + "');");
            sampleDB.execSQL("INSERT INTO " + tableName
                    + " (wordNum,word,meaning,wrongtimes)  Values ('" + 5 + "', '" + "고양시키다" +"','" + "기운을 북돋아주다" + "','" + 0 + "');");
            sampleDB.execSQL("INSERT INTO " + tableName
                    + " (wordNum,word,meaning,wrongtimes)  Values ('" + 6 + "', '" + "사양하다" +"','" + "무언가를 거절하다" + "','" + 0 + "');");



            sampleDB.close();

            Log.d("디비","디비성공");

        } catch (SQLiteException se) {
            Toast.makeText(getApplicationContext(),  se.getMessage(), Toast.LENGTH_LONG).show();
            Log.e("", se.getMessage());


        }

        showList();

        //db 관련
        //init_tables() ;
        //save_values() ;
        //load_values() ;

        LinearLayout layout_wordToMeaning = (LinearLayout) findViewById (R.id.main_change_wordToMeaning);
        //LinearLayout layout_meaningToWord = (LinearLayout) findViewById (R.id.main_change_meaningToWord);
        LinearLayout layout_wrongWordList = (LinearLayout) findViewById (R.id.main_change_wrongWordList);

        layout_wordToMeaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),WordToMeaningActivity.class);
                intent.putParcelableArrayListExtra("wordList",wordList);
                startActivity(intent);
            }
        });

//        layout_meaningToWord.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(),MeaningToWordActivity.class);
//                intent.putParcelableArrayListExtra("wordList",wordList);
//                startActivity(intent);
//            }
//        });

        layout_wrongWordList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),WrongWordListActivity.class);
                intent.putParcelableArrayListExtra("wordList",wordList);
                startActivity(intent);
            }
        });

    }



    private void init_tables() {
//        Log.d("디비","디비2");
//        dbHelper = new ContactDBHelper(this) ;
    }

    private void save_values() {
//        SQLiteDatabase db = dbHelper.getWritableDatabase() ;

        //db.execSQL(ContactDBCtrct.SQL_DELETE) ;

//        EditText editTextNo = (EditText) findViewById(R.id.editTextNo) ;
//        int no = Integer.parseInt(editTextNo.getText().toString()) ;
//
//        EditText editTextName = (EditText) findViewById(R.id.editTextName) ;
//        String name = editTextName.getText().toString() ;
//
//        EditText editTextPhone = (EditText) findViewById(R.id.editTextPhone) ;
//        String phone = editTextPhone.getText().toString() ;
//
//        CheckBox checkBoxOver20 = (CheckBox) findViewById(R.id.checkBoxOver20) ;
//        boolean isOver20 = checkBoxOver20.isChecked() ;

//        String sqlInsert = ContactDBCtrct.SQL_INSERT +
//                " (" +
//                1 + ", " +
//                "'" + "go" + "', " +
//                "'" + "iamgoing" + "', " +
//                2 +
//                ")" ;
//
//        Log.d("디비","디비3");
//
//        db.execSQL(sqlInsert) ;
    }

    protected void showList(){

        try {

            SQLiteDatabase ReadDB = this.openOrCreateDatabase(dbName, MODE_PRIVATE, null);


            //SELECT문을 사용하여 테이블에 있는 데이터를 가져옵니다..
            Cursor c = ReadDB.rawQuery("SELECT * FROM " + tableName, null);

            if (c != null) {

                    int temCount=0;
                if (c.moveToFirst()) {
                    do {

                        //테이블에서 4개의 컬럼값을 가져와서
                        String wordNumS = c.getString(c.getColumnIndex("wordNum"));
                        String wordS = c.getString(c.getColumnIndex("word"));
                        String meaningS = c.getString(c.getColumnIndex("meaning"));
                        String wrongtimesS = c.getString(c.getColumnIndex("wrongtimes"));

                       wordList.add(new Word(wordNumS,wordS,meaningS,wrongtimesS));
//
//                        Log.d("디비",wordList.get(0).getWordNum());
                        Log.d("디비",wordList.get(temCount++).getWord());
//                        Log.d("디비",wordList.get(0).getMeaning());
//                        Log.d("디비",wordList.get(0).getWrongTimes());


                    } while (c.moveToNext());
                }
            }

            ReadDB.close();








        } catch (SQLiteException se) {
            Toast.makeText(getApplicationContext(),  se.getMessage(), Toast.LENGTH_LONG).show();
            Log.e("",  se.getMessage());
        }

    }





}
