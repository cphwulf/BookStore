package bookstore;

import java.util.*;

public class BookStore {
    
    public static int retrieveNumberOfBooks(ArrayList<Book> books) {
     
        //Check for null values, i.e. empty slots in String array don't count
        int countBooks = 0;
        for (Book book : books) {
            if (book != null) {
                countBooks++;
            }
        }
        return countBooks;
    }

    //Assumption: every title in book list is unique    
    // Return book if a book matches search string (= title)
    public static Book findBookByFullTitle(ArrayList<Book> books, String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    // find and return FIRST book that matches search string (= title)
    public static Book findBookByPartOfTitle(ArrayList<Book> books, String title) {

        for (Book book : books) {
            if (book.getTitle().contains(title)) {
                return book;
            }
        }
        return null;
    }

    // find and return ALL books that match search string (= title)
    public static ArrayList<Book> findBooksByPartOfTitle(ArrayList<Book> books, String title) {
        ArrayList<Book> booksFound = new ArrayList();
        return booksFound;
    }

    // insert new book object and return new book list
    public static void insertBook(ArrayList<Book> books, Book book) {

        if (findBookByFullTitle(books, book.getTitle()) == null) {     
           books.add(book);
        }
        //We don't need to return anything since we haven't made new object
       
    }

    // display book list on screen
    public static void printList(ArrayList<Book> books) {
        System.out.println(books.toString());
    }

    public static void sortBooksTitle(ArrayList<Book> books) {

	    for (int i=0;i<books.size();i++) {
		    String tmpTitle = books.get(i).getTitle();
		    String tmpTitle2 = books.get(i+1).getTitle();
		    }
	    for (Book b: books) {
		    System.out.println(b.getTitle());
		    String tmpString = b.getTitle().toLowerCase();
		    System.out.println(tmpString);
	    }
    }
    
 // sort book list
    public static void sortBooks(ArrayList<Book> books) {
        //The easy way doesn't work any longer!
        //Arrays.sort(books);
             
        // Doing it manually - called Selection sort algorithm
        int smallindex;
        for (int i = 0; i < books.size(); i++) {
            smallindex = i; // set first element as smallest
            for (int j = i + 1; j < books.size(); j++) // find smallest
            {
                if (books.get(j).getTitle().compareTo(books.get(smallindex).getTitle()) < 0) {
                    smallindex = j;
                }
            }
            if (smallindex != i) {
                swap(books, smallindex, i);
            }
        }
    }

    static void swap(ArrayList<Book> array, int index1, int index2) {
        Book temp = array.get(index1);
        //notice use of set method to replace element
        array.set(index1, array.get(index2));       
        array.set(index2, temp);
    }

      public static void main(String[] args) {
        // Make list of books
        ArrayList<Book> bookList = new ArrayList();        
        Book b1 = new Book("Lord of the rings", "J.R.R. Tolkien", 1937);
        bookList.add(b1);
        Book b2 = new Book("Animal farm", "George Orwell", 1945);
        bookList.add(b2);
        Book b3 = new Book("To kill a mockingbird", "Harper Lee", 1960);
        bookList.add(b3);
        
        // Print list
        System.out.print("Initial book list: ");
        printList(bookList);
        
        //retrieve number of books
        System.out.println("Number of books " + retrieveNumberOfBooks(bookList));
	lookForTitle(bookList);
        sortBooksTitle(bookList);        
        printList(bookList);
        sortBooks(bookList);        
	/*
        System.out.print("Sorted book list by title: ");
        printList(bookList);
        Book b4 = new Book("And then there were none", "Agatha Christie", 1939);
        insertBook(bookList, b4);
        System.out.print("New book in end of book list: ");
        printList(bookList);
        sortBooks(bookList);
        System.out.print("Sorted book list by title: ");
        printList(bookList);
        insertBook(bookList, b4);
        System.out.print("No new book in end of book list: ");
        printList(bookList);
        Book title = findBookByFullTitle(bookList, "Animal farm");
        System.out.print("Search for full title \"Animal farm\". Result: ");
        System.out.println(title);
        title = findBookByFullTitle(bookList, "Animal f");
        System.out.print("Search for full title \"Animal f\". Result: ");
        System.out.println(title);
        title = findBookByPartOfTitle(bookList, "the");
        System.out.print("Search book for part of title \"the\". Result: ");
        System.out.println(title);
        ArrayList<Book>result = findBooksByPartOfTitle(bookList, "the");
        System.out.print("Search all books for part of title \"the\". Result: ");
        printList(result);
*/
    }    
}
