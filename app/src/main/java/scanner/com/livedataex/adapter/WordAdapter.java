package scanner.com.livedataex.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import scanner.com.livedataex.R;
import scanner.com.livedataex.localstorage.Word;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {

    private List<Word> wordList;

    public WordAdapter(List<Word> wordList) {
        this.wordList = wordList;
    }

    @NonNull
    @Override
    public WordAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.word_list_row, parent, false);

        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WordAdapter.WordViewHolder holder, int position) {
        Word word = wordList.get(position);
        holder.word.setText(word.nWord);
    }

    public void setData(List<Word> wl) {
        if (wordList != null) {
            PostDiffCallback postDiffCallback = new PostDiffCallback(wordList, wl);
            DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(postDiffCallback);
            wordList.clear();
            wordList.addAll(wl);
            diffResult.dispatchUpdatesTo(this);
        } else {
            wordList = wl;
        }
    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }

    public class WordViewHolder extends RecyclerView.ViewHolder {
        public TextView word;

        public WordViewHolder(View view) {
            super(view);
            word = view.findViewById(R.id.tv_item);

        }
    }

    class PostDiffCallback extends DiffUtil.Callback {

        private final List<Word> oldPosts, newPosts;

        public PostDiffCallback(List<Word> oldWords, List<Word> newWords) {
            this.oldPosts = oldWords;
            this.newPosts = newWords;
        }

        @Override
        public int getOldListSize() {
            return oldPosts.size();
        }

        @Override
        public int getNewListSize() {
            return newPosts.size();
        }

        @Override
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            return oldPosts.get(oldItemPosition).getPid() == newPosts.get(newItemPosition).getPid();
        }

        @Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return oldPosts.get(oldItemPosition).equals(newPosts.get(newItemPosition));
        }
    }
}
