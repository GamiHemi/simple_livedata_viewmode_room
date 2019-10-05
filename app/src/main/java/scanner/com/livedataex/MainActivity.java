package scanner.com.livedataex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import scanner.com.livedataex.localstorage.Word;
import scanner.com.livedataex.localstorage.WordDatabase;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private WordDatabase wDb;

    private Button add;

    private EditText etAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = findViewById(R.id.bt_add);
        etAdd = findViewById(R.id.et_word);

        wDb = WordDatabase.getInstance(getApplicationContext());

        add.setOnClickListener(v -> AppExecutors.getInstance().diskIO().execute(() -> {
            Word word = new Word();
            word.nWord = etAdd.getText().toString();
            wDb.WordDao().insertAll(word);
        }));


    }

}
