package scanner.com.livedataex.localstorage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Word {

    @PrimaryKey(autoGenerate = true)
    public int pid;

    public String getnWord() {
        return nWord;
    }

    public void setnWord(String nWord) {
        this.nWord = nWord;
    }

    @ColumnInfo
    public String nWord;

    public int getPid() {
        return pid;
    }

    public static DiffUtil.ItemCallback<Word> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Word>() {
                @Override
                public boolean areItemsTheSame(@NonNull Word oldWord,
                                               @NonNull Word newWord) {
                    return oldWord.getPid() == newWord.getPid();
                }

                @Override
                public boolean areContentsTheSame(@NonNull Word oldWord,
                                                  @NonNull Word newWord) {
                    return oldWord.equals(newWord);
                }
            };

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == this)
            return true;
        Word w = (Word) obj;
        return w.getPid() == this.getPid() &&
                w.getnWord() == w.getnWord();
    }

    @NonNull
    @Override
    public String toString() {
        return nWord;
    }
}
