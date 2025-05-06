package job.search.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {
    private String bookId;
    private String title;
    private String author;
    private boolean available;

    @Override
    public String toString() {
        return "Book{" +
                " title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", available=" + available +
                '}';
    }
}
