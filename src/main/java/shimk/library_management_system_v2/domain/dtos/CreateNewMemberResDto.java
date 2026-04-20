package shimk.library_management_system_v2.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shimk.library_management_system_v2.domain.enums.UserLoginStatusEnum;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateNewMemberResDto {

    private UUID id;
    private String name;
    private String username;
    private String password;
    private String email;
    private Integer telno; // phone number
    private String address;
    private String role; // user role
    private UserLoginStatusEnum status; // login status
    private LocalDateTime membershipStartDate;
    private LocalDateTime membershipEndDate;

}
