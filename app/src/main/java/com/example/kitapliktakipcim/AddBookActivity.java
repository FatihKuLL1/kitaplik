package com.example.kitapliktakipcim;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kitapliktakipcim.data.AppDatabase;
import com.example.kitapliktakipcim.data.Book;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.Executors;

public class AddBookActivity extends AppCompatActivity {
  private EditText titleInput, authorInput, pageCountInput;
  private Button saveButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_book);

    titleInput = findViewById(R.id.titleInput);
    authorInput = findViewById(R.id.authorInput);
    pageCountInput = findViewById(R.id.pageCountInput);
    saveButton = findViewById(R.id.saveButton);

    saveButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String title = titleInput.getText().toString();
        String author = authorInput.getText().toString();
        String pageCountStr = pageCountInput.getText().toString();

        if (title.isEmpty() || author.isEmpty() || pageCountStr.isEmpty()) {
          Toast.makeText(AddBookActivity.this, "Lütfen tüm alanları doldurun", Toast.LENGTH_SHORT).show();
          return;
        }

        int pageCount = Integer.parseInt(pageCountStr);
        String startDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPageCount(pageCount);
        book.setStartDate(startDate);

        Executors.newSingleThreadExecutor().execute(() -> {
          AppDatabase.getInstance(getApplicationContext()).bookDao().insertBook(book);
          runOnUiThread(() -> {
            Toast.makeText(AddBookActivity.this, "Kitap başarıyla eklendi", Toast.LENGTH_SHORT).show();
            finish();
          });
        });
      }
    });
  }
}
