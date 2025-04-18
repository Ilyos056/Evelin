package tadjik.ilyosjon.evelin.controller;

import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tadjik.ilyosjon.evelin.dto.IntroDto;
import tadjik.ilyosjon.evelin.dto.PhotoDto;
import tadjik.ilyosjon.evelin.model.Intro;
import tadjik.ilyosjon.evelin.model.Photo;
import tadjik.ilyosjon.evelin.model.Result;
import tadjik.ilyosjon.evelin.service.PhotoService;

import java.util.List;

@RestController
@RequestMapping("/api/photo")
public class PhotoController {
    @Autowired
    PhotoService photoService;

    @GetMapping
    public HttpEntity<?> findAll() {
        List<Photo> all = photoService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?>findById(@PathVariable Integer id) {
        Photo byId = photoService.getById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<?> create(@RequestBody PhotoDto photoDto) {
        Result result = photoService.create(photoDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody PhotoDto photoDto) {
        Result update = photoService.update(id, photoDto);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        Result delete = photoService.delete(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }
}
