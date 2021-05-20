package com.samaspace;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class BookManag {
	
	
	public static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("BookUnit");
	
	
	public static void addBook(String title, String author, float price) {
		
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		
		try {
			
			et = em.getTransaction();
			et.begin();
			
			Book book = new Book();
			book.setBookTitle(title);
			book.setBookAuthor(author);
			book.setBookPrice(price);
			
			em.persist(book);
			et.commit();
			
			
		} catch (Exception e) {
			
			if(et != null) {
				et.rollback();
			}
			e.printStackTrace();
		}
		
		finally {
			em.close();
		}
		
		
	}
	
	
	public static void getBookById(int id) {
			
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT b FROM Book b WHERE b.bookId = :bookID";
		
		TypedQuery<Book> tq = em.createQuery(query, Book.class);
		tq.setParameter("bookID", id);
		Book book = null;
		
		try {
			
			book = tq.getSingleResult();
			System.out.println("***** BOOK *****");
			System.out.println("### " + book.getBookTitle() + " " + "### " + book.getBookAuthor() + " " 
					+ "### " + book.getBookPrice());
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
		
		
	}
	
	public static void getAllBooks() {
		
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT b FROM Book b WHERE b.bookId IS NOT NULL";
		
		TypedQuery<Book> tq = em.createQuery(query, Book.class);
		List<Book> Books;
		
		try {
			
			Books = tq.getResultList();
			Books.forEach(bks->System.out.println("ID: " + bks.getBookId() + " Title: " + bks.getBookTitle() + " Author " + bks.getBookAuthor() + " Price: " + bks.getBookPrice()));
			
			
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		finally {
			em.close();
		}
		
	}
	
	public static void updateBook(int id, String t, String auth, float pr) {
		
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		Book b = null;
		
		try {
			
			et = em.getTransaction();
			et.begin();
			
			b = em.find(Book.class, id);
			b.setBookTitle(t);
			b.setBookAuthor(auth);
			b.setBookPrice(pr);
			
			
			em.persist(b);
			et.commit();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		finally {
			em.close();
		}
		
	}
	
	public static void rdeleteBook(int id) {
		
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		
		Book book = null;
		
		try {
			
			et = em.getTransaction();
			et.begin();
			
			book = em.find(Book.class, id);
			em.remove(book);
			
			et.commit();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		finally {
			em.close();
		}
		
		
		
	}
	
	public static void closeEntity() {
		ENTITY_MANAGER_FACTORY.close();
	}

}
