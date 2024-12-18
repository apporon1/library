package com.example.library;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Library library;
    private TextView outputTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        library = new Library();
        library.addBook("Война и мир", "Лев Толстой", "Роман");
        library.addBook("Анна Каренина", "Лев Толстой", "Роман");
        library.addBook("1984", "Джордж Оруэлл", "Антиутопия");
        library.addBook("Мастер и Маргарита", "Михаил Булгаков", "Фантастика");

        outputTextView = findViewById(R.id.outputTextView);
        Button showBooksButton = findViewById(R.id.showBooksButton);
        Button showAuthorsButton = findViewById(R.id.showAuthorsButton);
        Button showGenresButton = findViewById(R.id.showGenresButton);

        showBooksButton.setOnClickListener(v -> outputTextView.setText(library.getBooksInfo()));
        showAuthorsButton.setOnClickListener(v -> outputTextView.setText(library.getAuthorsInfo()));
        showGenresButton.setOnClickListener(v -> outputTextView.setText(library.getBooksByGenreInfo()));
    }
}
