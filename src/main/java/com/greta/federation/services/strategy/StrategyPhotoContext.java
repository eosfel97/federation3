package com.greta.federation.services.strategy;

import com.flickr4java.flickr.FlickrException;
import com.greta.federation.exception.ErrorCodes;
import com.greta.federation.exception.InvalidOperationException;
import lombok.Setter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.InputStream;

@Service
public class StrategyPhotoContext {

    private BeanFactory beanFactory;
    private Strategy strategy;
    @Setter
    private String context;

    @Autowired
    public StrategyPhotoContext(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public Object savePhoto(String context, Integer id, InputStream photo, String title) throws FlickrException {
        determinContext(context);
        return strategy.savePhoto(id, photo, title);
    }

    private void determinContext(String context) {
        final String beanName = context + "Strategy";
        switch (context) {
            case "article":
                strategy = beanFactory.getBean(beanName, SaveArticlePhoto.class);
                break;

            case "actualite" :
                strategy = beanFactory.getBean(beanName, SaveActualitePhoto.class);
                break;


            default: throw new InvalidOperationException("Contexte inconnue pour l'enregistrement de la photo", ErrorCodes.UNKNOWN_CONTEXT);
        }
    }


}

