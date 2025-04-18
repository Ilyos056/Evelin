package tadjik.ilyosjon.evelin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.evelin.dto.BlogDto;
import tadjik.ilyosjon.evelin.model.Blog;
import tadjik.ilyosjon.evelin.model.Result;
import tadjik.ilyosjon.evelin.repository.BlogRepo;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    BlogRepo blogRepo;


    public List<Blog> getall(){
        return blogRepo.findAll();
    }

    public Blog getbyid(Integer id){
        return blogRepo.findById(id).get();
    }

    public Result save(BlogDto blogDto){
        Blog blog = new Blog();
        blog.setName(blogDto.getName());
        blog.setDescription(blogDto.getDescription());
        blog.setEmail(blogDto.getEmail());
        blogRepo.save(blog);
        return new Result(true, "created");

    }

    public  Result update(Integer id , BlogDto blogDto){
        Optional<Blog> blog = blogRepo.findById(id);
        if (blog.isPresent()) {
            Blog blog1 = blog.get();
            blog1.setName(blogDto.getName());
            blog1.setDescription(blogDto.getDescription());
            blog1.setEmail(blogDto.getEmail());
            blogRepo.save(blog1);
            return new Result(true, "updated");
        }
        return new Result(false, "not found");
    }

    public Result delete(Integer id){
        Optional<Blog> blog = blogRepo.findById(id);
        if (blog.isPresent()) {
            blogRepo.delete(blog.get());
            return new Result(true, "deleted");
        }
        return new Result(false, "not found");
    }
}
