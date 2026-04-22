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
import shimk.library_management_system_v2.domain.CreateBookReqVo;
import shimk.library_management_system_v2.domain.CreateNewMemberReqVo;
import shimk.library_management_system_v2.domain.dtos.CreateBookReqDto;
import shimk.library_management_system_v2.domain.dtos.CreateBookResDto;
import shimk.library_management_system_v2.domain.dtos.CreateNewMemberReqDto;
import shimk.library_management_system_v2.domain.dtos.CreateNewMemberResDto;
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

    @PostMapping(value = {"/admin/createMember" , "/librarian/createMember"})
    public ResponseEntity<CreateNewMemberResDto> createMember(
            @AuthenticationPrincipal Jwt jwt,
            @Valid @RequestBody CreateNewMemberReqDto createNewMemberReqDto
    ){

        CreateNewMemberReqVo createNewMemberReqVo = userMapper.fromDto(createNewMemberReqDto); // dto -> reqVo
        UUID id = UUID.fromString(jwt.getSubject()); // get user id from jwt

        UserInfo createdMember = userService.createMember(createNewMemberReqVo);
        CreateNewMemberResDto createNewMemberResDto = userMapper.toDto(createdMember); // map to dto

        return new ResponseEntity<>(createNewMemberResDto, HttpStatus.CREATED); // create new obj to responses

    }




}
