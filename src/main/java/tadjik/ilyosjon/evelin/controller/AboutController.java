package tadjik.ilyosjon.evelin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tadjik.ilyosjon.evelin.dto.AboutDto;
import tadjik.ilyosjon.evelin.dto.IntroDto;
import tadjik.ilyosjon.evelin.model.About;
import tadjik.ilyosjon.evelin.model.Intro;
import tadjik.ilyosjon.evelin.model.Result;
import tadjik.ilyosjon.evelin.service.AboutService;

import java.util.List;

@RestController
@RequestMapping("/api/about")
public class AboutController {
    @Autowired
    AboutService aboutService;

    @GetMapping
    public HttpEntity<?> findAll() {
        List<About> all = aboutService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?>findById(@PathVariable Integer id) {
        About byId = aboutService.findById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<?> create(@RequestBody AboutDto aboutDto) {
        Result result = aboutService.create(aboutDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody AboutDto aboutDto) {
        Result update = aboutService.update(id, aboutDto);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        Result delete = aboutService.delete(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }
}
