package tadjik.ilyosjon.evelin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tadjik.ilyosjon.evelin.dto.BlogDto;
import tadjik.ilyosjon.evelin.model.Blog;
import tadjik.ilyosjon.evelin.model.Result;
import tadjik.ilyosjon.evelin.service.BlogService;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogController {
    @Autowired
    BlogService blogService;


    @GetMapping
    public HttpEntity<?> getBlog() {
        List<Blog> blogList = blogService.getall();
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getBlogById(@PathVariable Integer id) {
        Blog blog = blogService.getbyid(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<?> addBlog(BlogDto blogDto) {
        Result result = blogService.save(blogDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> updateBlog(BlogDto blogDto, @PathVariable Integer id) {
        Result result = blogService.update(id, blogDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteBlog(@PathVariable Integer id) {
        Result result = blogService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
