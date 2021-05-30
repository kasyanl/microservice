package by.jrr.fp.photos.client;

import by.jrr.fp.photos.bean.Album;
import by.jrr.fp.photos.bean.Photo;
import by.jrr.fp.photos.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AlbumClient {

    @Autowired
    RestTemplate restTemplate;

    String uri = "https://jsonplaceholder.typicode.com/albums";

    public List<Album> getAllAlbumsResponseEntity() {
        ResponseEntity<Album[]> result = restTemplate.getForEntity(uri, Album[].class);
        return Arrays.asList(result.getBody());
    }

    public Iterable<Album> getAlbums() {
        return List.of(restTemplate
                .getForEntity(uri, Album[].class)
                .getBody());
    }

    public Album getPhotoById(Long id) throws Exception {
        try {
            return restTemplate.getForObject(uri + "/{id}", Album.class, id);
        } catch (Exception ex) {
            throw new EntityNotFoundException(String.format("AlbumClient couldn't find album id=%s", id));
        }
    }

    public List<Album> searchAlbumById(Long id) { //example with uri builder and headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri)
                .queryParam("id", id);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<Album[]> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                Album[].class);
        return Arrays.asList(response.getBody());
    }

    public void updateAlbum(Album album) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", album.getId().toString());

        restTemplate.put(uri + "/{id}", album, params);
    }

    public URI createAlbum(Album album) {
        return restTemplate.postForLocation(uri, album, String.class);
    }

    public void deleteAlbumById(Long id) {
        restTemplate.delete(uri + "/{id}", id);
    }
}
