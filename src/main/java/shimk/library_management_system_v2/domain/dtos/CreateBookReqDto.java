package shimk.library_management_system_v2.domain.dtos;

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
public class CreateBookReqDto {

    @NotBlank(message = "ISBN cannot be blank")
    private String ISBN;

    @NotBlank(message = "title cannot be blank")
    private String title;

    @NotBlank(message = "Author cannot be blank")
    private String author;

    @NotBlank(message = "Publisher cannot be blank")
    private String publisher;

    @NotNull(message = "Published Year cannot be null")
    private Integer publishYear;

    @NotNull(message = "Category information is required")
    private CategoryEnum category;

    @NotNull(message = "Total copies cannot be null")
    private Integer totalCopies;

    @NotBlank(message = "Shelf number cannot be blank")
    private String shelfNum;

    private String description;








}
