package shimk.library_management_system_v2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shimk.library_management_system_v2.domain.entities.UserInfo;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, UUID> {
}

// Boot Jpa method in build, mark as DAO component
