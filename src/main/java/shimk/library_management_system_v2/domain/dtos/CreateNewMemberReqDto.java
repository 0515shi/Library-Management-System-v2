package shimk.library_management_system_v2.domain.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class CreateNewMemberReqDto {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "User name is required")
    private String username;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "email is required")
    private String email;

    @NotBlank(message = "Phone number is required")
    private String telno; // phone number

    @NotNull(message = "Address is required")
    private String address;

    @NotNull(message = "Role is required")
    private UserRolesEnum role; // user role

    private UserLoginStatusEnum status; // login status

    @JsonProperty("membership_start")
    private LocalDateTime membershipStartDate;

    @JsonProperty("membership_end")
    private LocalDateTime membershipEndDate;










}
