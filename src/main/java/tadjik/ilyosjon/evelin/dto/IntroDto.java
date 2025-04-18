package tadjik.ilyosjon.evelin.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tadjik.ilyosjon.evelin.model.Photo;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IntroDto {
    private Integer photo_id;
    private String description;
}
