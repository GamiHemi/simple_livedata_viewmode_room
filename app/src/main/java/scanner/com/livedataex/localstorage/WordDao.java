package scanner.com.livedataex.localstorage;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface WordDao {

    /*@Query("SELECT * FROM word")
    LiveData<List<Word>> getAll();*/

    @Query("SELECT * FROM word")
    public abstract DataSource.Factory<Integer,Word> getAll();

    @Insert
    void insertAll(Word... words);
}
