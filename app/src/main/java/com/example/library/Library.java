package com.example.library;

import java.util.*;

public class Library {

    private static class Book {
        String title;
        String author;
        String genre;

        public Book(String title, String author, String genre) {
            this.title = title;
            this.author = author;
            this.genre = genre;
        }

        @Override
        public String toString() {
            return "Книга: " + title + ", Автор: " + author + ", Жанр: " + genre;
        }
    }

    private List<Book> books;
    private Set<String> authors;
    private Map<String, List<Book>> booksByGenre;

    public Library() {
        books = new ArrayList<>();
        authors = new HashSet<>();
        booksByGenre = new HashMap<>();
    }

    public void addBook(String title, String author, String genre) {
        Book book = new Book(title, author, genre);
        books.add(book);
        authors.add(author);

        booksByGenre.putIfAbsent(genre, new ArrayList<>());
        booksByGenre.get(genre).add(book);
    }

    public String getBooksInfo() {
        StringBuilder sb = new StringBuilder();
        for (Book book : books) {
            sb.append(book).append("\n");
        }
        return sb.toString();
    }

    public String getAuthorsInfo() {
        StringBuilder sb = new StringBuilder();
        for (String author : authors) {
            sb.append(author).append("\n");
        }
        return sb.toString();
    }

    public String getBooksByGenreInfo() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<Book>> entry : booksByGenre.entrySet()) {
            sb.append("Жанр: ").append(entry.getKey()).append("\n");
            for (Book book : entry.getValue()) {
                sb.append("  ").append(book).append("\n");
            }
        }
        return sb.toString();
    }
}

