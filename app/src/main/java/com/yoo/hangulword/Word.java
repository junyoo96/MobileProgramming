package com.yoo.hangulword;

import android.os.Parcel;
import android.os.Parcelable;

public class Word implements Parcelable {

    private String wordNum;
    private String word;
    private String meaning;
    private String wrongTimes;

    public Word(String wordNum, String word, String meaning, String wrongTimes) {
        this.wordNum = wordNum;
        this.word = word;
        this.meaning = meaning;
        this.wrongTimes = wrongTimes;
    }

    public String getWordNum() {
        return wordNum;
    }

    public void setWordNum(String wordNum) {
        this.wordNum = wordNum;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getWrongTimes() {
        return wrongTimes;
    }

    public void setWrongTimes(String wrongTimes) {
        this.wrongTimes = wrongTimes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    private Word(Parcel in) {
        // This order must match the order in writeToParcel()
        wordNum = in.readString();
        word = in.readString();
        meaning = in.readString();
        wrongTimes = in.readString();
        // Continue doing this for the rest of your member data
    }

    public void writeToParcel(Parcel out, int flags) {
        // Again this order must match the Question(Parcel) constructor
        out.writeString(wordNum);
        out.writeString(word);
        out.writeString(meaning);
        out.writeString(wrongTimes);
        // Again continue doing this for the rest of your member data
    }

    // Just cut and paste this for now
    public static final Parcelable.Creator<Word> CREATOR = new Parcelable.Creator<Word>() {
        public Word createFromParcel(Parcel in) {
            return new Word(in);
        }

        public Word[] newArray(int size) {
            return new Word[size];
        }
    };
}
