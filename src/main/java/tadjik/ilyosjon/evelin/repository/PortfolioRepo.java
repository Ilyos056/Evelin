package tadjik.ilyosjon.evelin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.evelin.model.Portfolio;

public interface PortfolioRepo extends JpaRepository<Portfolio, Integer> {
    boolean existsById(Integer id);
}
