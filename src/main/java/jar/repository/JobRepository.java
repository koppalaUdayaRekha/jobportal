package jar.repository;

import jar.entity.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {

    Page<Job> findByTitleContainingIgnoreCaseOrLocationContainingIgnoreCase(
            String title,
            String location,
            Pageable pageable
    );
}