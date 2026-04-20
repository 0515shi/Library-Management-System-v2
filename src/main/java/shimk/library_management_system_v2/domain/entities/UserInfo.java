package shimk.library_management_system_v2.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import shimk.library_management_system_v2.domain.enums.UserLoginStatusEnum;
import shimk.library_management_system_v2.domain.enums.UserRolesEnum;

import java.time.LocalDateTime;
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
@Table(name = "lib_user")
public class UserInfo {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id; // user id

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "username", nullable = false, updatable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "telno", nullable = false)
    private String telno;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "role", nullable = false)
    private UserRolesEnum role;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserLoginStatusEnum status; // current login status

    @Column(name = "membership_start", nullable = false)
    private LocalDateTime membershipStartDate; // start date

    @Column(name = "membership_end")
    private LocalDateTime membershipEndDate; // end date

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt; // user create date time

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt; // user update profile date time

    @OneToMany(mappedBy = "user")
    private List<LoanInfo> loans = new ArrayList<>(); // how many loans a user have

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(id, userInfo.id) && Objects.equals(name, userInfo.name) && Objects.equals(username, userInfo.username) && Objects.equals(password, userInfo.password) && Objects.equals(email, userInfo.email) && Objects.equals(telno, userInfo.telno) && Objects.equals(address, userInfo.address) && role == userInfo.role && status == userInfo.status && Objects.equals(membershipStartDate, userInfo.membershipStartDate) && Objects.equals(membershipEndDate, userInfo.membershipEndDate) && Objects.equals(createdAt, userInfo.createdAt) && Objects.equals(updatedAt, userInfo.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, username, password, email, telno, address, role, status, membershipStartDate, membershipEndDate, createdAt, updatedAt);
    }
}
