package by.jrr.fp.web.proxy;

import by.jrr.fp.web.model.Album;
import by.jrr.fp.web.model.Photo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "PHOTO")
public interface PhotoProxy {
    String photos = "/photos";
    String albums = "/albums";

    @GetMapping(photos)
    PagedModel<Photo> getAllPhotos();

    @GetMapping(albums)
    PagedModel<Album> getAllAlbums();
}
