package com.samaspace;

public class Application {

	public static void main(String[] args) {
		
		
		//BookManag.addBook("Title4", "Oussama", 680);
		//BookManag.getBookById(3);
		//BookManag.updateBook(5, "The life is a heaven", "hawkander", 20);
		BookManag.getAllBooks();
		BookManag.rdeleteBook(3);
		BookManag.getAllBooks();
		BookManag.closeEntity();
		

	}

}
