package com.breez.practice_two.library;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {

	private final Map<String, Book> catalogBook;
	private final Map<Integer, Reader> readers;

	public Library() {
		this.catalogBook = new HashMap<>();
		this.readers = new HashMap<>();
	}

	public List<Book> getCatalog() {
		return this.catalogBook.values().stream().toList();
	}

	public List<Reader> getReaders() {
		return this.readers.values().stream().toList();
	}

	public Book getBook(String name) {
		return this.catalogBook.remove(name);
	}

	public void addToCatalog(Book book) {
		this.catalogBook.putIfAbsent(book.getName(), book);
	}

	public void addReader(Reader reader) {
		this.readers.putIfAbsent(reader.getrId(), reader);
	}

	@Override
	public String toString() {
		StringBuilder resultString = new StringBuilder();

		resultString.append("Количество книг в библиотеке: ").append(catalogBook.size()).append("\n");
		resultString.append("Названия книг: \n");
		for (Book book : catalogBook.values()) {
			resultString.append("\t- ").append(book.getName()).append("\n");
		}

		resultString.append("\nКоличество читателей: ").append(readers.size()).append("\n");
		for (Reader reader : readers.values()) {
			resultString.append("\t- ").append(reader.getName()).append("\n");
		}

		resultString.append("\nИнформация о взятых книгах:\n");
		for (Reader reader : readers.values()) {
			List<Book> takenBooks = reader.getTakenBooks();
			if (!takenBooks.isEmpty()) {
				resultString.append("\t").append(reader.getName()).append(":\n");
				for (Book book : takenBooks) {
					resultString.append("\t\t- ").append(book.getName()).append("\n");
				}
			}
		}

		return resultString.toString();
	}

}
