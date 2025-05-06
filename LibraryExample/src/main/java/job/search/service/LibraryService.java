package job.search.service;

import job.search.dto.Book;
import job.search.dto.Library;
import job.search.dto.Student;

import static job.search.validator.BookValidator.validateIssue;
import static job.search.validator.BookValidator.validateReturn;

public interface LibraryService {
    Library library = new Library();

    static void takeBook(String bookTitle, Student student) {
        Book book = validateIssue(bookTitle, student, library.getBookList());
        student.getBookIdList().add(book.getBookId());
        book.setAvailable(false);
        System.out.printf("%n %s is issued to %s %n", book, student.getStudName());
    }

    static void returnBook(String bookTitle, Student student) {
        Book book = validateReturn(bookTitle, student, library.getBookList());
        student.getBookIdList().remove(book.getBookId());
        book.setAvailable(true);
        System.out.printf("%n %s is returned by %s %n", book, student.getStudName());
    }

}
