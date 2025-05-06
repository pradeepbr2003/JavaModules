package job.search;

import job.search.common.StudentEnum;
import job.search.helper.LibraryHelper;

import java.util.Arrays;

public class LibraryExample {

    public static void main(String[] args) {
        Arrays.stream(StudentEnum.values())
                .map(LibraryHelper::getStudent).forEach(LibraryHelper::process);
    }
}