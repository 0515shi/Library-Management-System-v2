package shimk.library_management_system_v2.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "books")
public class BookInfo {

    @Id
    @Column(name = "ISBN", updatable = false, nullable = false)
    private String ISBN;

    @Column(name = "title", updatable = false, nullable = false)
    private String title; // book title

    @Column(name = "author", updatable = false, nullable = false)
    private String author; // author

    @Column(name = "publisher", updatable = false, nullable = false)
    private String publisher;

    @Column(name = "publish_year", nullable = false)
    private Integer publishYear;

    @Column(name = "total_copies", nullable = false)
    private Integer totalCopies; // number of books originally

    @Column(name = "available_copies", nullable = false)
    private Integer availableCopies; // number of books currently

    @Column(name = "shelf_num", nullable = false)
    private String shelfNum; // location of the book

    @Column(name = "decription")
    private String description;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    // 1 book title can have many book copies
    @OneToMany(mappedBy = "bookInfo", cascade = CascadeType.ALL) // parent
    private List<BookCopiesInfo> bookCopies = new ArrayList<>(); // bookCopiesInfo of the specific book

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryInfo categoryInfo;


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BookInfo bookInfo = (BookInfo) o;
        return Objects.equals(ISBN, bookInfo.ISBN) && Objects.equals(title, bookInfo.title) && Objects.equals(author, bookInfo.author) && Objects.equals(publisher, bookInfo.publisher) && Objects.equals(publishYear, bookInfo.publishYear) && Objects.equals(totalCopies, bookInfo.totalCopies) && Objects.equals(availableCopies, bookInfo.availableCopies) && Objects.equals(shelfNum, bookInfo.shelfNum) && Objects.equals(description, bookInfo.description) && Objects.equals(createdAt, bookInfo.createdAt) && Objects.equals(updatedAt, bookInfo.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ISBN, title, author, publisher, publishYear, totalCopies, availableCopies, shelfNum, description, createdAt, updatedAt);
    }
}
