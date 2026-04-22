package shimk.library_management_system_v2.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shimk.library_management_system_v2.domain.CreateBookReqVo;
import shimk.library_management_system_v2.domain.dtos.CreateBookReqDto;
import shimk.library_management_system_v2.domain.dtos.CreateBookResDto;
import shimk.library_management_system_v2.domain.entities.BookInfo;
import shimk.library_management_system_v2.mappers.BookMapper;
import shimk.library_management_system_v2.services.BookService;

@RestController
@RequestMapping(value = "/api/v2/books")
public class BookController {

    @Autowired
    BookMapper bookMapper;

    @Autowired
    BookService bookService;

    // create book controller
    @PostMapping(value = {"/admin/createBooks", "/librarian/createBooks"})
    public ResponseEntity<CreateBookResDto> createBook(
            @AuthenticationPrincipal Jwt jwt,
            @Valid @RequestBody CreateBookReqDto createBookReqDto
    ){

        CreateBookReqVo createBookReqVo = bookMapper.fromDto(createBookReqDto);
        System.out.println(createBookReqVo);

        BookInfo createdBook = bookService.createBook(createBookReqVo);
        CreateBookResDto createBookResDto = bookMapper.toDto(createdBook);
        return new ResponseEntity<>(createBookResDto,HttpStatus.CREATED);

    }



}
