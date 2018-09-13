package com.ilyaiparshin.word_stock;

import java.util.Date;
import java.util.UUID;

public class Word {

    private UUID mId;
    private String mWord;
    private String mTranslate;
    private String mDfinition;
    private Date mDate;
    private Boolean mFavorite;

    public Word(){
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getWord() {
        return mWord;
    }

    public String getTranslate() {
        return mTranslate;
    }

    public String getDfinition() {
        return mDfinition;
    }

    public Date getDate() {
        return mDate;
    }

    public Boolean getFavorite() {
        return mFavorite;
    }

    public void setWord(String word) {
        mWord = word;
    }

    public void setTranslate(String translate) {
        mTranslate = translate;
    }

    public void setDfinition(String dfinition) {
        mDfinition = dfinition;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public void setFavorite(Boolean favorite) {
        mFavorite = favorite;
    }
}
