package tadjik.ilyosjon.evelin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.evelin.model.Blog;

public interface BlogRepo extends JpaRepository<Blog, Integer> {
}
