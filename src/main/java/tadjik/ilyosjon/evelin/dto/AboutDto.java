package tadjik.ilyosjon.evelin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AboutDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
