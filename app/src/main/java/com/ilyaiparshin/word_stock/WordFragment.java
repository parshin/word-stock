package com.ilyaiparshin.word_stock;

import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.UUID;

public class WordFragment extends Fragment {

    private static final String ARG_WORD_ID = "word_id";
    private Word mWord;
    private EditText mWordEditText;
    private CheckBox mFavoriteCheckBox;

    public static WordFragment newInstance(UUID wordId){
        Bundle args = new Bundle();
        args.putSerializable(ARG_WORD_ID, wordId);
        WordFragment fragment = new WordFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        UUID wordId = (UUID) getArguments().getSerializable(ARG_WORD_ID);
        mWord = WordDB.get(getActivity()).getWord(wordId);
    }

//    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View word_view = inflater.inflate(R.layout.fragment_word, container, false);

        mWordEditText = (EditText) word_view.findViewById(R.id.word);
        mWordEditText.setText(mWord.getWord());
        mWordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                mWord.setWord(charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mFavoriteCheckBox = (CheckBox) word_view.findViewById(R.id.favorite);
        mFavoriteCheckBox.setChecked(mWord.getFavorite());
        mFavoriteCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mWord.setFavorite(b);
            }
        });

        return word_view;
    }
}
