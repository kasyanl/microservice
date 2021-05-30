package by.jrr.fp.web.service;

import by.jrr.fp.web.model.Photo;
import by.jrr.fp.web.proxy.PhotoProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumService {

    @Autowired
    PhotoProxy photoProxy;

    public List<Photo> findAll() {
        PagedModel<Photo> result = photoProxy.getAllPhotos();
        result.getContent();
        return new ArrayList<>(result.getContent());
    }
}
