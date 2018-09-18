package com.ilyaiparshin.word_stock;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.UUID;

public class WordActivity extends SingleFragmentActivity {

    private static final String EXTRA_WORD_ID = "com.ilyaiparshin.android.word_stock.word_id";

    public static Intent newIntent(Context context, UUID wordId){
        Intent intent = new Intent(context, WordActivity.class);
        intent.putExtra(EXTRA_WORD_ID, wordId);
        return  intent;
    }

    @Override
    protected Fragment createFragment(){

        UUID wordId = (UUID) getIntent().getSerializableExtra(EXTRA_WORD_ID);
        return WordFragment.newInstance(wordId);
    }
}
