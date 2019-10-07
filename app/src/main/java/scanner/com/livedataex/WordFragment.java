package scanner.com.livedataex;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import scanner.com.livedataex.adapter.WordAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class WordFragment extends Fragment {

    private WordAdapter mAdapter;

    public WordFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_word, container, false);
        WordViewModel wordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);
        wordViewModel.init(wordViewModel.wordDao);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        RecyclerView recyclerView = view.findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mAdapter = new WordAdapter();

        wordViewModel.wordsList.observe(this, words -> mAdapter.submitList(words));
        recyclerView.setAdapter(mAdapter);

        return view;
    }

}
