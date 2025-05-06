package job.search;

import job.search.common.StudentEnum;
import job.search.dto.Student;
import job.search.helper.LibraryHelper;
import job.search.service.LibraryService;

import java.util.Arrays;
import java.util.List;

public class LibraryExample {

    public static void main(String[] args) {
        List<Student> studentList = Arrays.stream(StudentEnum.values())
                .map(LibraryHelper::getStudent).toList();
        studentList.forEach(LibraryHelper::takeBook);

        while (LibraryService.library.getBookList().stream().anyMatch(b -> !b.isAvailable())) {
            studentList.forEach(LibraryHelper::returnBook);
        }

        System.out.printf("%n Available books in library :  %n");
        LibraryService.library.getBookList().forEach(System.out::println);
    }
}