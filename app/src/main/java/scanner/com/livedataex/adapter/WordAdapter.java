package scanner.com.livedataex.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import scanner.com.livedataex.R;
import scanner.com.livedataex.localstorage.Word;

public class WordAdapter extends PagedListAdapter<Word, WordAdapter.WordViewHolder> {

    public WordAdapter() {
        super(Word.DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.word_list_row, parent, false);

        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WordAdapter.WordViewHolder holder, int position) {
        Word word = getItem(position);
        if (word != null) {
            holder.bindTo(word);
        }
    }

    public class WordViewHolder extends RecyclerView.ViewHolder {
        private TextView w;

        WordViewHolder(View view) {
            super(view);
            w = view.findViewById(R.id.tv_item);
        }

        private void bindTo(Word word) {
            w.setText(word.nWord);
        }
    }


}
