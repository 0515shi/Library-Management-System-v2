package shimk.library_management_system_v2.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePasswordReqDto{
    @NotBlank(message = "Current Password must not be empty")
    private String currPass;

    @NotBlank(message = "New Password must not be empty")
    private String newPass;

    @NotBlank(message = "Confirm Password must not be empty")
    private String confPass;
}
