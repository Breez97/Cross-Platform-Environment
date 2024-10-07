package com.breez.practice_two.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {

	public static void main(String[] args) {
		Library library = new Library();
		Random random = new Random();

		List<String> bookNames = List.of("Silent Echoes", "Lost Horizon", "Hidden Path", "Burning Skies",
				"Frozen Shadows", "Crimson Moon", "Whispering Winds", "Broken Chains", "Endless Journey",
				"Midnight Flames");

		for (String bookName : bookNames) {
			library.addToCatalog(new Book(bookName));
		}

		List<String> readerNames = List.of("Lena Archer", "Samuel Fletcher", "Elena Graves", "Sophia Winters", "Lucas Hale");
		for (String readerName : readerNames) {
			library.addReader(new Reader(readerName));
		}

		List<Book> availableBooks = new ArrayList<>(library.getCatalog());
		List<Reader> readers = library.getReaders();

		for (Reader reader : readers) {
			if (!availableBooks.isEmpty()) {
				int bookIndex = random.nextInt(availableBooks.size());
				Book book = availableBooks.get(bookIndex);
				reader.takeBook(book);
				availableBooks.remove(bookIndex);
			}
		}

		while (!availableBooks.isEmpty()) {
			Reader reader = readers.get(random.nextInt(readers.size()));
			int bookIndex = random.nextInt(availableBooks.size());
			Book book = availableBooks.get(bookIndex);
			reader.takeBook(book);
			availableBooks.remove(bookIndex);
		}

		System.out.println(library);
	}
}