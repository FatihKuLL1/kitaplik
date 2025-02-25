package com.example.kitapliktakipcim;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kitapliktakipcim.data.AppDatabase;
import com.example.kitapliktakipcim.data.Book;

import java.util.List;
import java.util.concurrent.Executors;

public class BookListActivity extends AppCompatActivity {
  private RecyclerView recyclerView;
  private BookListAdapter adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_book_list);

    recyclerView = findViewById(R.id.recyclerView);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    Executors.newSingleThreadExecutor().execute(() -> {
      List<Book> books = AppDatabase.getInstance(getApplicationContext()).bookDao().getAllBooks();
      runOnUiThread(() -> {
        adapter = new BookListAdapter(books);
        recyclerView.setAdapter(adapter);
      });
    });
  }
}
