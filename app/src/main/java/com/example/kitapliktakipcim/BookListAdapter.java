package com.example.kitapliktakipcim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kitapliktakipcim.data.Book;

import java.util.List;

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.BookViewHolder> {
  private final List<Book> books;

  public BookListAdapter(List<Book> books) {
    this.books = books;
  }

  @NonNull
  @Override
  public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
    return new BookViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
    Book book = books.get(position);
    holder.titleTextView.setText(book.getTitle());
    holder.authorTextView.setText(book.getAuthor());
    holder.pageCountTextView.setText(String.valueOf(book.getPageCount()));
  }

  @Override
  public int getItemCount() {
    return books.size();
  }

  static class BookViewHolder extends RecyclerView.ViewHolder {
    TextView titleTextView, authorTextView, pageCountTextView;

    public BookViewHolder(@NonNull View itemView) {
      super(itemView);
      titleTextView = itemView.findViewById(R.id.titleTextView);
      authorTextView = itemView.findViewById(R.id.authorTextView);
      pageCountTextView = itemView.findViewById(R.id.pageCountTextView);
    }
  }
}
