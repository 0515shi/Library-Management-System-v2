package shimk.library_management_system_v2.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shimk.library_management_system_v2.domain.enums.CategoryEnum;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookResDto {

    private String ISBN;

    private String title;

    private String author;

    private String publisher;

    private CategoryEnum category;

    private Integer publishYear;

    private Integer totalCopies;

    private Integer availableCopies;

    private String shelfNum;

    private String description;

}
