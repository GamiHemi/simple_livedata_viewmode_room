package scanner.com.livedataex;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import scanner.com.livedataex.localstorage.Word;
import scanner.com.livedataex.localstorage.WordDao;
import scanner.com.livedataex.localstorage.WordDatabase;

public class WordViewModel extends AndroidViewModel {

    WordDao wordDao;

    LiveData<PagedList<Word>> wordsList;

    WordDatabase wordDatabase;

    public WordViewModel(@NonNull Application application) {
        super(application);
        wordDatabase = WordDatabase.getInstance(this.getApplication());
        wordDao = wordDatabase.WordDao();
    }

    public void init(WordDao wordDao) {
        PagedList.Config pagedListConfig =
                (new PagedList.Config.Builder()).setEnablePlaceholders(true)
                        .setPrefetchDistance(10)
                        .setPageSize(20).build();

        wordsList = (new LivePagedListBuilder(wordDao.getAll()
                , pagedListConfig))
                .build();
    }

}
