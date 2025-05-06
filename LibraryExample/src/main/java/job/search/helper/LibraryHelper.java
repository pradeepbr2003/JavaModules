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

    static void process(Student student) {
        String bookTitle = BookAuthor.values()
                [random.nextInt(0, BookAuthor.values().length)].name();
        LibraryService.takeBook(bookTitle, student);
        LibraryService.returnBook(bookTitle, student);
    }

    static Student getStudent(StudentEnum se) {
        return Student.builder()
                .studId(UUID.randomUUID().toString())
                .studName(se.name()).bookIdList(new ArrayList<>())
                .build();
    }

}
