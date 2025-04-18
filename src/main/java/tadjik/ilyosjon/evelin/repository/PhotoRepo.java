package tadjik.ilyosjon.evelin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.evelin.model.Photo;

public interface PhotoRepo extends JpaRepository<Photo, Integer> {

    boolean existsById(Integer id);
}
