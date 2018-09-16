package com.ilyaiparshin.word_stock;

import android.support.v4.app.Fragment;

public class WordListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment(){
        return new WordListFragment();
    }
}
