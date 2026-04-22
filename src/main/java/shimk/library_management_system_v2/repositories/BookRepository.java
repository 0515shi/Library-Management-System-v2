package shimk.library_management_system_v2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shimk.library_management_system_v2.domain.entities.BookInfo;

@Repository
public interface BookRepository extends JpaRepository<BookInfo, String> {
}
