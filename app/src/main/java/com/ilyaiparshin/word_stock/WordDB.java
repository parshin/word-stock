package com.ilyaiparshin.word_stock;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class WordDB {
    private static WordDB sWordDB;

    private List<Word> mWords;

    public static WordDB get(Context context){
        if(sWordDB == null){
            sWordDB = new WordDB(context);
        }
        return sWordDB;
    }
    private WordDB(Context context){
        mWords = new ArrayList<>();

        Word word = new Word();
        word.setWord("one");
        word.setFavorite(false);
        mWords.add(word);

        Word word2 = new Word();
        word2.setWord("two");
        word2.setFavorite(false);
        mWords.add(word2);

        Word word3 = new Word();
        word3.setWord("three");
        word3.setFavorite(false);
        mWords.add(word3);

        Word word4 = new Word();
        word4.setWord("four");
        word4.setFavorite(false);
        mWords.add(word4);
    }
    public List<Word> getWords(){
        return mWords;
    }
    public Word getWord(UUID id){
        for(Word word : mWords){
            if (word.getId().equals(id)){
                return word;
            }
        }
        return null;
    }

}

