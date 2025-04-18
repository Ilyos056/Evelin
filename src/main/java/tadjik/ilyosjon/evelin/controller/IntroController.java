package tadjik.ilyosjon.evelin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tadjik.ilyosjon.evelin.dto.IntroDto;
import tadjik.ilyosjon.evelin.model.Intro;
import tadjik.ilyosjon.evelin.model.Result;
import tadjik.ilyosjon.evelin.service.IntroService;

import java.util.List;

@RestController
@RequestMapping("/api/intro")
public class IntroController {
    @Autowired
    IntroService introService;

    @GetMapping
    public HttpEntity<?>findAll() {
        List<Intro> all = introService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?>findById(@PathVariable Integer id) {
        Intro byId = introService.getById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<?> create(@RequestBody IntroDto introDto) {
        Result result = introService.create(introDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody IntroDto introDto) {
        Result update = introService.update(id, introDto);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        Result delete = introService.delete(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }
}
