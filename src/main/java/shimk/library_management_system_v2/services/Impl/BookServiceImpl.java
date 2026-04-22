package shimk.library_management_system_v2.services.Impl;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shimk.library_management_system_v2.domain.CreateBookReqVo;
import shimk.library_management_system_v2.domain.entities.BookInfo;
import shimk.library_management_system_v2.repositories.BookRepository;
import shimk.library_management_system_v2.repositories.UserRepository;
import shimk.library_management_system_v2.services.BookService;

@Service
@Slf4j
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public BookInfo createBook(CreateBookReqVo createBookReqVo){

        BookInfo createBook = BookInfo.builder()
                .ISBN(createBookReqVo.getISBN())
                .title(createBookReqVo.getTitle())
                .author(createBookReqVo.getAuthor())
                .publisher(createBookReqVo.getPublisher())
                .publishYear(createBookReqVo.getPublishYear())
                .category(createBookReqVo.getCategory())
                .totalCopies(createBookReqVo.getTotalCopies())
                .availableCopies(createBookReqVo.getTotalCopies())
                .shelfNum(createBookReqVo.getShelfNum())
                .description(createBookReqVo.getDescription())
                .build();

        return bookRepository.save(createBook);
    }

}
