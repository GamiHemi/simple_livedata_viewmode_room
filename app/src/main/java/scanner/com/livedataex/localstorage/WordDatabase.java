package scanner.com.livedataex.localstorage;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Word.class}, version = 1)
public abstract class WordDatabase extends RoomDatabase {

    private static final Object sLock = new Object();
    private static WordDatabase instance;

    public static WordDatabase getInstance(final Context context) {
        synchronized (sLock) {
            if (instance == null) {
                instance = Room.databaseBuilder(context.getApplicationContext(),
                        WordDatabase.class, "Words.db")
                        .build();
            }
            return instance;
        }
    }

    public abstract WordDao WordDao();
}
