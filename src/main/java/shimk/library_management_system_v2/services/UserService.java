package shimk.library_management_system_v2.services;

import shimk.library_management_system_v2.domain.CreateNewMemberReqVo;
import shimk.library_management_system_v2.domain.dtos.CreateNewMemberResDto;
import shimk.library_management_system_v2.domain.entities.UserInfo;

public interface UserService {

    UserInfo createMember(CreateNewMemberReqVo createNewMemberReqVo);

}
