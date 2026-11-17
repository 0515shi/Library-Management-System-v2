package shimk.library_management_system_v2.services;

import shimk.library_management_system_v2.domain.CreateNewMemberReqVo;
import shimk.library_management_system_v2.domain.dtos.CommonResDto;
import shimk.library_management_system_v2.domain.dtos.UpdatePasswordReqDto;
import shimk.library_management_system_v2.domain.entities.UserInfo;

import java.util.UUID;

public interface UserService {

    UserInfo createMember(CreateNewMemberReqVo createNewMemberReqVo);
    CommonResDto changePassword(UUID ID, UpdatePasswordReqDto updatePasswordReqDto);
    
}
