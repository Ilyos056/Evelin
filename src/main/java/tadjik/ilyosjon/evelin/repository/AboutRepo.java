package tadjik.ilyosjon.evelin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.evelin.model.About;

public interface AboutRepo extends JpaRepository<About, Integer> {
    boolean existsById(Integer id);

}
