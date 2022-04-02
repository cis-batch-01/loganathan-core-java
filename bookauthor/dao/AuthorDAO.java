package com.technocis.bookauthor.dao;

import java.util.List;

import com.technocis.bookauthor.model.Author;
import com.technocis.bookauthor.model.Books;

public interface AuthorDAO {
     public Author insertAuthor(Author author);
     public List<Author> getAllAuthorList() ;
     public List<Author> getAllAuthorBookList(String  bookId);
     public Author getAuthor(String authorId);
}
