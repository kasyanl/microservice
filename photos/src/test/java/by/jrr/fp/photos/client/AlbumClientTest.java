package by.jrr.fp.photos.client;

import by.jrr.fp.photos.bean.Album;
import by.jrr.fp.photos.bean.Photo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AlbumClientTest {

    @Autowired
    AlbumClient albumClient;

    @Test
    void getAlbums() {
        List<Album> result = albumClient.getAllAlbumsResponseEntity();
        assertEquals(100, result.size());
    }

    @Test
    void getAlbumById() throws Exception{
        Album album = albumClient.getPhotoById(1L);
        assertEquals(1, album.getId());
    }

    @Test
    void searchAlbumById() {
        List<Album> albums = albumClient.searchAlbumById(1L);
        assertEquals(1, albums.size());
        assertEquals(1, albums.get(0).getId());
    }

    @Test
    void updateAlbum() {
        Album album = new Album();
        album.setId(1L);
        albumClient.updateAlbum(album);
    }

    @Test
    void createAlbum() {
        Album album = new Album();
        URI result = albumClient.createAlbum(album);
        assertEquals("/albums/101", result.getPath());
    }

    @Test
    void deleteAlbumById() {
        albumClient.deleteAlbumById(0L);
    }
}
