package shimk.library_management_system_v2.domain.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "book_copies")
public class BookCopiesInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "copy_number", nullable = false)
    private Integer copyNumber;

    @ManyToOne(fetch = FetchType.LAZY) // child
    @JoinColumn(name = "book_id")
    private BookInfo bookInfo;

    @OneToOne(mappedBy = "currentBookCopy") // parent
    private LoanInfo currentLoan;

    @OneToMany(mappedBy = "bookCopy") // parent
    private List<LoanInfo> loanHistory = new ArrayList<>(); // list all loan history


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BookCopiesInfo that = (BookCopiesInfo) o;
        return Objects.equals(id, that.id) && Objects.equals(copyNumber, that.copyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, copyNumber);
    }
}
