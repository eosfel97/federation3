package greta.federation.dto;


import greta.federation.entity.EvenementRencontre;
import greta.federation.entity.Image;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ImageDto {
    private Integer id;
    private String nom;
    private String description;
    private ArticleDto article;
    private ActualiteDto actualite;

    public static ImageDto fromEntity(Image image) {
        if (image == null) {
            return null;
        }
        return ImageDto.builder()
                .id(image.getId())
                .nom(image.getNom())
                .description(image.getDescription())
                .article(ArticleDto.fromEntity(image.getArticle()))
                .actualite(ActualiteDto.fromEntity(image.getActualite()))
                .build();
    }
    public static Image toEntity(ImageDto imageDto) {
        if (imageDto == null) {
            return null;
        }
        Image image = new Image();
        image.setId(imageDto.getId());
        image.setNom(imageDto.getNom());
        image.setDescription(imageDto.getDescription());
        image.setArticle(ArticleDto.toEntity(imageDto.getArticle()));
        image.setActualite(ActualiteDto.toEntity(imageDto.getActualite()));

        return image;
    }

}
