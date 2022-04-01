package com.technocis.bookauthor.dao;

import java.util.List;

import com.technocis.bookauthor.model.Author;
import com.technocis.bookauthor.model.Books;

public interface AuthorDAO {
     public Author insertAuthor(Author author);
     public List<Author> getAllAuthor() ;
     public List<Books> getAllAuthor(String  bookId);
}
