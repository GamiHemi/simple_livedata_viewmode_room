package scanner.com.livedataex.localstorage;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Word {

    @PrimaryKey(autoGenerate = true)
    public int pid;

    @ColumnInfo
    public String nWord;

    public int getPid() {
        return pid;
    }
}
