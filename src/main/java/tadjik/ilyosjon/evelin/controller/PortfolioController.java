package tadjik.ilyosjon.evelin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tadjik.ilyosjon.evelin.dto.PortfolioDto;
import tadjik.ilyosjon.evelin.model.Portfolio;
import tadjik.ilyosjon.evelin.model.Result;
import tadjik.ilyosjon.evelin.service.PortfolioService;

import java.util.List;

@RestController
@RequestMapping("/api/portfolio")
public class PortfolioController {
    @Autowired
    PortfolioService portfolioService;

    @GetMapping
    public HttpEntity<?> getPortfolio() {
        List<Portfolio> portfolioList = portfolioService.getall();
        return new ResponseEntity<>(portfolioList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getPortfolioById(@PathVariable Integer id) {
        Portfolio portfolio = portfolioService.getbyid(id);
        return new ResponseEntity<>(portfolio, HttpStatus.OK);
    }
    @PostMapping
    public HttpEntity<?> createPortfolio(@RequestBody PortfolioDto portfolioDto) {
        Result result = portfolioService.save(portfolioDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> updatePortfolio(@PathVariable Integer id, @RequestBody PortfolioDto portfolioDto) {
        Result result = portfolioService.update(id, portfolioDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> deletePortfolio(@PathVariable Integer id) {
        Result result = portfolioService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
