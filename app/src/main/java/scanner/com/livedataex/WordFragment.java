package scanner.com.livedataex;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import scanner.com.livedataex.adapter.WordAdapter;
import scanner.com.livedataex.localstorage.Word;
import scanner.com.livedataex.localstorage.WordDatabase;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class WordFragment extends Fragment {

    private List<Word> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private WordAdapter mAdapter;
    //private WordDatabase wDb;
    WordViewModel wordViewModel;

    public WordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_word, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.my_recycler_view);

        mAdapter = new WordAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        wordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);
        wordViewModel.getAllWords().observe(this, words -> mAdapter.setData(words));

       /* wDb = WordDatabase.getInstance(getContext());
        wDb.WordDao().getAll().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> wordList) {

                for (int i = 0; i < wordList.size(); i++) {
                    Log.e("check", wordList.get(i).nWord);
                }
            }
        });*/
    }
}
