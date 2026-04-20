package shimk.library_management_system_v2.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import shimk.library_management_system_v2.domain.CreateNewMemberReqVo;
import shimk.library_management_system_v2.domain.dtos.CreateNewMemberReqDto;
import shimk.library_management_system_v2.domain.dtos.CreateNewMemberResDto;
import shimk.library_management_system_v2.domain.entities.UserInfo;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    CreateNewMemberReqVo fromDto(CreateNewMemberReqDto dto);

    CreateNewMemberResDto toDto(UserInfo userInfo); // service layer to Dto
}
