package job.search.validator;

import job.search.dto.Book;
import job.search.dto.Student;

import java.util.List;
import java.util.Optional;

public interface BookValidator {


    static Book validateIssue(String bookTitle, Student student, List<Book> bookList) {
        Book book = BookValidator.bookExist(bookTitle, bookList);
        BookValidator.bookAvailable(book);
        BookValidator.bookIssued(student, book);
        return book;
    }

    static Book validateReturn(String bookTitle, Student student, List<Book> bookList) {
        Book book = BookValidator.bookExist(bookTitle, bookList);
        BookValidator.bookReturned(student, book);
        return book;
    }

    static void bookIssued(Student student, Book book) {
        if (student.getBookIdList() != null && student.getBookIdList().contains(book.getBookId()))
            throw new RuntimeException(String.format("%n %s is already issued to %s %n", book.getTitle(), student.getStudName()));
    }

    static void bookReturned(Student student, Book book) {
        if (student.getBookIdList() != null && !student.getBookIdList().contains(book.getBookId()))
            throw new RuntimeException(String.format("%n %s is not taken by %s %n", book.getTitle(), student.getStudName()));
    }

    static Book bookExist(String bookTitle, List<Book> bookList) {
        Optional<Book> optBook = bookList.stream().filter(b -> b.getTitle().equalsIgnoreCase(bookTitle)).findAny();
        if (!optBook.isPresent()) {
            throw new RuntimeException(String.format("%n %s book does not exists %n", bookTitle));
        }
        return optBook.get();
    }

    static void bookAvailable(Book book) {
        if (!book.isAvailable()) {
            throw new RuntimeException(String.format("%n %s book is not available %n", book.getTitle()));
        }
    }
}
