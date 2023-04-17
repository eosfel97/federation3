package greta.federation.services.strategy;

import com.flickr4java.flickr.FlickrException;
import greta.federation.dto.ActualiteDto;
import greta.federation.dto.ArticleDto;
import greta.federation.exception.ErrorCodes;
import greta.federation.exception.InvalidOperationException;
import greta.federation.services.ActualiteService;
import greta.federation.services.ArticleService;
import greta.federation.services.FlickrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;

@Service("actualiteStrategy")
@Slf4j
public class SaveActualitePhoto implements Strategy<ActualiteDto> {

    private FlickrService flickrService;
    private ActualiteService actualiteService;

    @Autowired
    public SaveActualitePhoto(FlickrService flickrService, ActualiteService actualiteService) {
        this.flickrService = flickrService;
        this.actualiteService = actualiteService;
    }

    @Override
    public ActualiteDto savePhoto(Integer id, InputStream photo, String titre) throws FlickrException {
        ActualiteDto actualite = actualiteService.findById(id);
        String urlPhoto = flickrService.savePhoto(photo, titre);
        if (!StringUtils.hasLength(urlPhoto)) {
            throw new InvalidOperationException("Erreur lors de l'enregistrement de photo de l'actualite", ErrorCodes.UPDATE_PHOTO_EXCEPTION);
        }
        actualite.setPhoto(urlPhoto);
        return actualiteService.save(actualite);
    }
}
