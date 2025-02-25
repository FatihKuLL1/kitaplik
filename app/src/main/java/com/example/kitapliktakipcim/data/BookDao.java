package com.example.kitapliktakipcim.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BookDao {
  @Insert
  void insertBook(Book book);

  @Query("SELECT * FROM books")
  List<Book> getAllBooks();
}
