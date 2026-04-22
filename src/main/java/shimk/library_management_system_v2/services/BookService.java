package shimk.library_management_system_v2.services;

import shimk.library_management_system_v2.domain.CreateBookReqVo;
import shimk.library_management_system_v2.domain.entities.BookInfo;

public interface BookService {

    BookInfo createBook(CreateBookReqVo createBookReqVo);

}
