package shimk.library_management_system_v2.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shimk.library_management_system_v2.domain.enums.CategoryEnum;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookReqVo {

    private String ISBN;

    private String title;

    private String author;

    private String publisher;

    private Integer publishYear;

    private CategoryEnum category;

    private Integer totalCopies;

    private String shelfNum;

    private String description;
}
