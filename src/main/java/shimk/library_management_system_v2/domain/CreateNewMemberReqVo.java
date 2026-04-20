package shimk.library_management_system_v2.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shimk.library_management_system_v2.domain.enums.UserLoginStatusEnum;
import shimk.library_management_system_v2.domain.enums.UserRolesEnum;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateNewMemberReqVo {

    private String name;
    private String username;
    private String password;
    private String email;
    private Integer telno; // phone number
    private String address;
    private UserRolesEnum role; // user role
    private UserLoginStatusEnum status; // login status
    private LocalDateTime membershipStartDate;
    private LocalDateTime membershipEndDate;

}
