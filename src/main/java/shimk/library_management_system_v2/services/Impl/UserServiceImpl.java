package shimk.library_management_system_v2.services.Impl;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import shimk.library_management_system_v2.domain.CreateNewMemberReqVo;
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

        System.out.println(createMember.getMembershipStartDate()); // ok

        return userRepository.save(createMember); // save to database and return saved user

    }

}
