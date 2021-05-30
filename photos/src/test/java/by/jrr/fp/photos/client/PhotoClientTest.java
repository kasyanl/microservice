package by.jrr.fp.photos.client;

import by.jrr.fp.photos.bean.Photo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PhotoClientTest {

    @Autowired
    PhotoClient photoClient;

    @Test
    void getPhotos() {
        ResponseEntity<Photo[]> result = photoClient.getPhotosResponse();
        assertEquals(5000, result.getBody().length);
        assertEquals(result.getStatusCode(), HttpStatus.valueOf(200));
    }

    @Test
    void getPhotoById() {
        Photo photo = photoClient.getPhotoById(1L);
        assertEquals(1, photo.getId());
    }

    @Test
    void searchPhotoById() {
        List<Photo> photos = photoClient.searchPhotoById(1L);
        assertEquals(1, photos.size());
        assertEquals(1, photos.get(0).getId());
    }

    @Test
    void updatePhoto() {
        Photo photo = new Photo();
        photoClient.updatePhoto(photo);
    }

    @Test
    void createPhoto() {
        Photo photo = new Photo();
        URI result = photoClient.createPhoto(photo);
        assertEquals("/photos/5001", result.getPath());
    }

    @Test
    void deletePhotoById() {
        photoClient.deletePhotoById(1L);
    }
}
