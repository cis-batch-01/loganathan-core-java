package com.technocis.library.DAO;

import java.util.List;

import com.technocis.library.model.Author;

public interface AuthorDAO {
	public Author getAuthor(int id);
	public List<Author> getAllAuthor();
	public Author addAuthor(Author author);
	public Author updateAuthor(int id,Author author);
	public Author deleteAuthor(int id);
}
