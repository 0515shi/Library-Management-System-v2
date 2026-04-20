package shimk.library_management_system_v2.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import shimk.library_management_system_v2.domain.enums.UserLoanStatusEnum;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateLoanReqVo {

    private LocalDateTime dueDate; // can extend dueDate

    private LocalDateTime returnDate;

    private UserLoanStatusEnum status;

    private Double fine;


}
