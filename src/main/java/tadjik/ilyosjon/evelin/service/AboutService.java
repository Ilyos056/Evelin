package tadjik.ilyosjon.evelin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.evelin.dto.AboutDto;
import tadjik.ilyosjon.evelin.model.About;
import tadjik.ilyosjon.evelin.model.Result;
import tadjik.ilyosjon.evelin.repository.AboutRepo;

import java.util.List;
import java.util.Optional;

@Service
public class AboutService {
    @Autowired
    AboutRepo aboutrepo;

    public List<About> findAll() {
        return aboutrepo.findAll();
    }

    public About findById(Integer id) {
        return aboutrepo.findById(id).get();
    }

    public Result create(AboutDto aboutDto) {
        About about = new About();
        about.setFirstName(aboutDto.getFirstName());
        about.setLastName(aboutDto.getLastName());
        about.setEmail(aboutDto.getEmail());
        about.setPassword(aboutDto.getPassword());
        aboutrepo.save(about);
        return new Result(true, "Successfully created intro");
    }

    public Result update(Integer id, AboutDto aboutDto) {
        Optional<About> optionalAbout = aboutrepo.findById(id);
        if (optionalAbout.isPresent()) {

            About about = optionalAbout.get();
            about.setFirstName(aboutDto.getFirstName());
            about.setLastName(aboutDto.getLastName());
            about.setEmail(aboutDto.getEmail());
            about.setPassword(aboutDto.getPassword());
            aboutrepo.save(about);
            return new Result(true, "Successfully updated intro");
        }
        return new Result(false, "Successfully updated intro");
    }

    public Result delete(Integer id) {
        aboutrepo.deleteById(id);
        return new Result(true, "Successfully deleted intro");
    }
}
