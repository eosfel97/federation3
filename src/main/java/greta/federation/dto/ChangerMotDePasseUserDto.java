package greta.federation.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ChangerMotDePasseUserDto {
    private Integer id;

    private String motDePasse;

    private String confirmMotDePasse;
}
