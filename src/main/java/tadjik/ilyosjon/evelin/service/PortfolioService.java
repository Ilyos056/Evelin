package tadjik.ilyosjon.evelin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.evelin.dto.PortfolioDto;
import tadjik.ilyosjon.evelin.model.Portfolio;
import tadjik.ilyosjon.evelin.model.Result;
import tadjik.ilyosjon.evelin.repository.PortfolioRepo;

import java.util.List;
import java.util.Optional;

@Service
public class PortfolioService {
    @Autowired
    PortfolioRepo portfolioRepo;

    public List<Portfolio> getall(){
        return portfolioRepo.findAll();
    }

    public Portfolio getbyid(Integer id){
        return portfolioRepo.findById(id).get();
    }

    public Result save(PortfolioDto portfolioDto){
        Portfolio portfolio = new Portfolio();
        portfolio.setName(portfolioDto.getName());
        portfolio.setDescription(portfolioDto.getDescription());
        portfolio.setPath(portfolioDto.getPath());
        portfolioRepo.save(portfolio);
        return new Result(true, "created");

    }

    public  Result update(Integer id , PortfolioDto portfolioDto){
        Optional<Portfolio> portfolio = portfolioRepo.findById(id);
        if (portfolio.isPresent()) {
            Portfolio portfolio1 = portfolio.get();
            portfolio1.setName(portfolioDto.getName());
            portfolio1.setDescription(portfolioDto.getDescription());
            portfolio1.setPath(portfolioDto.getPath());
            portfolioRepo.save(portfolio1);
            return new Result(true, "updated");
        }
        return new Result(false, "not found");
    }

    public Result delete(Integer id){
        Optional<Portfolio> portfolio = portfolioRepo.findById(id);
        if (portfolio.isPresent()) {
            portfolioRepo.delete(portfolio.get());
            return new Result(true, "deleted");
        }
        return new Result(false, "not found");
    }
}
