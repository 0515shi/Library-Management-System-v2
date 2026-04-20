package shimk.library_management_system_v2.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import shimk.library_management_system_v2.domain.enums.UserLoanStatusEnum;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "loans")
public class LoanInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "due_date", nullable = false)
    private LocalDateTime dueDate; // can extend dueDate

    @Column(name = "return_date")
    private LocalDateTime returnDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private UserLoanStatusEnum status;

    @Column(name = "fine")
    private Double fine;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @OneToOne
    @JoinColumn(name = "current_book_copy_id")  // child
    private BookCopiesInfo currentBookCopy;

    @ManyToOne
    @JoinColumn(name = "book_copy_id") // child
    private BookCopiesInfo bookCopy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserInfo user; // that specific user that own loan

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LoanInfo loanInfo = (LoanInfo) o;
        return Objects.equals(id, loanInfo.id) && Objects.equals(dueDate, loanInfo.dueDate) && Objects.equals(returnDate, loanInfo.returnDate) && status == loanInfo.status && Objects.equals(fine, loanInfo.fine) && Objects.equals(createdAt, loanInfo.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dueDate, returnDate, status, fine, createdAt);
    }
}
