package scanner.com.livedataex;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import androidx.lifecycle.LiveData;
import scanner.com.livedataex.localstorage.Word;
import scanner.com.livedataex.localstorage.WordDao;
import scanner.com.livedataex.localstorage.WordDatabase;

public class WordViewModel extends AndroidViewModel {

    WordDao wordDao;

    public WordViewModel(@NonNull Application application) {
        super(application);
        wordDao = WordDatabase.getInstance(application).WordDao();
    }

    LiveData<List<Word>> getAllWords() {
        return wordDao.getAll();
    }
}
