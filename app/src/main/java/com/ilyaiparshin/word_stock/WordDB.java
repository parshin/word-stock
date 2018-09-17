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

        for (int i = 0; i < 100; i++){
            Word word = new Word();
            word.setWord("Word"+Integer.toString(i));
            word.setDfinition("Definition"+Integer.toString(i));
            word.setTranslate("Translate"+Integer.toString(i));
            word.setFavorite(i % 2 == 0);
            mWords.add(word);
        }
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

