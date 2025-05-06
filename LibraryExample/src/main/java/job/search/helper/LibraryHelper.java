package job.search.helper;

import job.search.common.BookAuthor;
import job.search.common.StudentEnum;
import job.search.dto.Student;
import job.search.service.LibraryService;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public interface LibraryHelper {
    Random random = new Random();

    static void takeBook(Student student) {
        try {
            String bookTitle = BookAuthor.values()[random.nextInt(0, BookAuthor.values().length)].name();
            LibraryService.takeBook(bookTitle, student);
        } catch (RuntimeException rte) {
            System.out.printf("%n Exception : %s %n", rte.getMessage());
        }
    }

    static void returnBook(Student student) {
        try {
            String bookTitle = BookAuthor.values()[random.nextInt(0, BookAuthor.values().length)].name();
            LibraryService.returnBook(bookTitle, student);


        } catch (RuntimeException rte) {
            System.out.printf("%n Exception : %s %n", rte.getMessage());
        }

    }

    static Student getStudent(StudentEnum se) {
        return Student.builder()
                .studId(UUID.randomUUID().toString())
                .studName(se.name()).bookIdList(new ArrayList<>())
                .build();
    }

}
