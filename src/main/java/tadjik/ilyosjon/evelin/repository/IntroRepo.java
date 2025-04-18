package tadjik.ilyosjon.evelin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.evelin.model.Intro;

public interface IntroRepo extends JpaRepository<Intro, Integer> {
    boolean existsById(Integer id);

}
