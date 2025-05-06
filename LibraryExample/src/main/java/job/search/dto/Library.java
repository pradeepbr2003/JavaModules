package job.search.dto;

import job.search.common.BookAuthor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Data
public class Library {
    private List<Book> bookList = new ArrayList<>();

    public Library() {
        Arrays.stream(BookAuthor.values()).map(ba -> Book.builder()
                .bookId(UUID.randomUUID().toString())
                .title(ba.name()).author(ba.value(ba.name())).available(true)
                .build()).forEach(bookList::add);


        System.out.printf("%n Available books in library :  %n");
        bookList.forEach(System.out::println);
    }
}
