package com.greta.federation.controller.api;

import com.flickr4java.flickr.FlickrException;
import com.greta.federation.utils.Constants;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Api("photos")
public interface PhotoApi {

    @PostMapping(Constants.APP_ROOT + "/save/{id}/{title}/{context}")
    Object savePhoto(@PathVariable("context") String context, @PathVariable("id") Integer id, @RequestPart("file") MultipartFile photo, @PathVariable(
            "title") String title) throws IOException,
            FlickrException;

}