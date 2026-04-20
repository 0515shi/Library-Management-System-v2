package shimk.library_management_system_v2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing //  automatically populate fields like "created date", "modified date", "created by", and "modified by"
public class JPAconfig {
}
