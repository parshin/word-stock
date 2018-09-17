package com.ilyaiparshin.word_stock;

import android.os.Bundle;
import android.print.PrinterId;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class WordListFragment extends Fragment{

    private RecyclerView mWordRecycleView;
    private WordAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_word_list, container, false);
        mWordRecycleView = (RecyclerView) view.findViewById(R.id.word_recycler_view);
        mWordRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateUI() {
        WordDB worddb = WordDB.get(getActivity());
        List<Word> words = worddb.getWords();

        mAdapter = new WordAdapter(words);
        mWordRecycleView.setAdapter(mAdapter);
    }

    private class WordHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private Word mWord;
        private TextView mWordTextView;
        private TextView mTranslateTextView;
        private ImageView mFavoriteImageView;

        public WordHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.list_item_word, parent, false));

            itemView.setOnClickListener(this);

            mWordTextView = (TextView) itemView.findViewById(R.id.word_title);
            mTranslateTextView = (TextView) itemView.findViewById(R.id.word_translate);
            mFavoriteImageView = (ImageView) itemView.findViewById(R.id.word_favorite);
        }

        public void bind(Word word){
            mWord = word;
            mWordTextView.setText(mWord.getWord());
            mTranslateTextView.setText(mWord.getTranslate());
            mFavoriteImageView.setVisibility(word.getFavorite() ? View.VISIBLE:View.GONE);
        }

        @Override
        public void onClick(View view){
            Toast.makeText(getActivity(), mWord.getWord(), Toast.LENGTH_SHORT).show();
        }
    }

    private class WordAdapter extends RecyclerView.Adapter<WordHolder> {
        private List<Word> mWords;

        public WordAdapter(List<Word> words){
            mWords = words;
        }

        @Override
        public WordHolder onCreateViewHolder(ViewGroup parent, int viewType){
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new WordHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(WordHolder holder, int position){
            Word word = mWords.get(position);
            holder.bind(word);
        }

        @Override
        public int getItemCount(){
            return mWords.size();
        }
    }


}
