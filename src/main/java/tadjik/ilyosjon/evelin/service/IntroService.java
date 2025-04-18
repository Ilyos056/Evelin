package tadjik.ilyosjon.evelin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.evelin.dto.IntroDto;
import tadjik.ilyosjon.evelin.model.Intro;
import tadjik.ilyosjon.evelin.model.Result;
import tadjik.ilyosjon.evelin.repository.IntroRepo;

import java.util.List;
import java.util.Optional;

@Service
public class IntroService {
    @Autowired
    IntroRepo introRepo;

    public List<Intro> getAll() {
        return introRepo.findAll();
    }

    public Intro getById(Integer id) {
        return introRepo.findById(id).get();
    }

    public Result create(IntroDto introDto) {
        Intro intro = new Intro();
        intro.setDescription(introDto.getDescription());
        introRepo.save(intro);
        return new Result(true, "Successfully saved intro");
    }

    public Result update(Integer id,  IntroDto introDto) {
        Optional<Intro> optionalIntro = introRepo.findById(id);
        if (optionalIntro.isPresent()) {
            Intro intro = optionalIntro.get();
            intro.setDescription(introDto.getDescription());
            introRepo.save(intro);

            return new Result(true, "Successfully updated intro");
        }
        return new Result(false, "Successfully updated intro");
    }

    public Result delete(Integer id) {
        introRepo.deleteById(id);
        return new Result(true, "Successfully deleted intro");
    }
}
