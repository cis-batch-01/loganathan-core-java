package com.technocis.bookauthor.dao;

import java.util.List;

import com.technocis.bookauthor.model.Author;
import com.technocis.bookauthor.model.Books;

public interface BooksDAO {
	public Books insertBooks(Books book);
    public List<Books> getAllBooks(String id);
    public List<Author> getAllAuthorBooks(String  authorId);
}
