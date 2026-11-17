package shimk.library_management_system_v2.controllers;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shimk.library_management_system_v2.domain.CreateNewMemberReqVo;
import shimk.library_management_system_v2.domain.dtos.*;
import shimk.library_management_system_v2.domain.entities.UserInfo;
import shimk.library_management_system_v2.mappers.UserMapper;
import shimk.library_management_system_v2.services.UserService;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v2/user")
public class UserController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    private UUID getUserId(Jwt jwt){
        return UUID.fromString(jwt.getSubject());
    }

    @PostMapping(value = {"/admin/createMember" , "/librarian/createMember"})
    public ResponseEntity<CreateNewMemberResDto> createMember(
            @AuthenticationPrincipal Jwt jwt,
            @Valid @RequestBody CreateNewMemberReqDto createNewMemberReqDto
    ){

        CreateNewMemberReqVo createNewMemberReqVo = userMapper.fromDto(createNewMemberReqDto); // dto -> reqVo
        UUID id = getUserId(jwt);

        UserInfo createdMember = userService.createMember(createNewMemberReqVo);
        CreateNewMemberResDto createNewMemberResDto = userMapper.toDto(createdMember); // map to dto

        return new ResponseEntity<>(createNewMemberResDto, HttpStatus.CREATED); // create new obj to responses

    }

    @PostMapping(value = {"/changePassword"})
    public ResponseEntity<CommonResDto> changePassword(
        @AuthenticationPrincipal Jwt jwt,
        @Valid @RequestBody UpdatePasswordReqDto updatePasswordReqDto
    ){
        UUID id = getUserId(jwt);
        CommonResDto changePasswordRes = userService.changePassword(id, updatePasswordReqDto);
        return new ResponseEntity<>(changePasswordRes, HttpStatus.ACCEPTED);
    }

    




}
