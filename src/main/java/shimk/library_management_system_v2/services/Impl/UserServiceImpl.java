package shimk.library_management_system_v2.services.Impl;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import shimk.library_management_system_v2.domain.CreateNewMemberReqVo;
import shimk.library_management_system_v2.domain.dtos.UpdatePasswordReqDto;
import shimk.library_management_system_v2.domain.entities.UserInfo;
import shimk.library_management_system_v2.repositories.UserRepository;
import shimk.library_management_system_v2.services.UserService;

@Service
@Slf4j // logging
@Transactional
public class UserServiceImpl implements UserService {

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(); // create encode obj

    @Autowired
    UserRepository userRepository;


    @Override
    public UserInfo createMember(CreateNewMemberReqVo createNewMemberReqVo){

        UserInfo createMember = UserInfo.builder()
                .email(createNewMemberReqVo.getEmail())
                .name(createNewMemberReqVo.getName())
                .address(createNewMemberReqVo.getAddress())
                .membershipStartDate(createNewMemberReqVo.getMembershipStartDate())
                .membershipEndDate(createNewMemberReqVo.getMembershipEndDate())
                .username(createNewMemberReqVo.getUsername())
                .password(
                        bCryptPasswordEncoder.encode(createNewMemberReqVo.getPassword())
                )
                .status(createNewMemberReqVo.getStatus())
                .role(createNewMemberReqVo.getRole())
                .telno(createNewMemberReqVo.getTelno())
                .build();

        return userRepository.save(createMember); // save to database and return saved user

    }

    @Override 
    public CommonResDto changePassword(UUID id, UpdatePasswordReqDto updatePasswordReqDto){
        UserInfo existingUser = UserRepository.findById(id);
        CommonResDto commonResDto = new CommonResDto();
        commonResDto.setStatus("FAIL"); // Default: FAIL
        
        String userCurrPass = bCryptPasswordEncoder.encode(existingUser.getPassword());
        String userInputCurrPass = bCryptPasswordEncoder.encode(updatePasswordReqDto.getCurrPass());
        String newPass = bCryptPasswordEncoder.encode(updatePasswordReqDto.getNewPass());
        String confPass = bCryptPasswordEncoder.encode(updatePasswordReqDto.getConfPass());
        
        if(existingUser == null){
            commonResDto.setErrMsg("User does not exist.");
            return commonResDto;
        }
        if(newPass != confPass){
            commonResDto.setErrMsg("New Password has to be identical as the Confirm Password.");
            return commonResDto;
        }
        if(userCurrPass != userInputCurrPass){
            commonResDto.setErrMsg("Current Password is incorrect. Please check and retry.");
        }

        existingUser.setPassword(newPass);
        commonResDto.setStatus("SUCCESS");
        commonResDto.setErrMsg(null);
        return commonResDto;
    }

}
