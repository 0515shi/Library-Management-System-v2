package shimk.library_management_system_v2.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import shimk.library_management_system_v2.domain.CreateBookReqVo;
import shimk.library_management_system_v2.domain.dtos.CreateBookReqDto;
import shimk.library_management_system_v2.domain.dtos.CreateBookResDto;
import shimk.library_management_system_v2.domain.entities.BookInfo;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {

    @Mapping(source = "category", target = "category")
    CreateBookReqVo fromDto(CreateBookReqDto dto);

    @Mapping(source = "category", target = "category")
    CreateBookResDto toDto(BookInfo bookInfo);
}
