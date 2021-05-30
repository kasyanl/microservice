package by.jrr.fp.photos.client;

import by.jrr.fp.photos.bean.Photo;
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
public class PhotoClient {

    @Autowired
    RestTemplate restTemplate;

    String uri = "https://jsonplaceholder.typicode.com/photos";

    public ResponseEntity<Photo[]> getPhotosResponse() {
        return restTemplate.getForEntity(uri, Photo[].class);
    }

    public Iterable<Photo> getPhotos() {
        return List.of(restTemplate
                .getForEntity(uri, Photo[].class)
                .getBody());
    }

    public Photo getPhotoById(Long id) {
        return restTemplate.getForObject(uri+"/{id}", Photo.class, id);
    }

    public List<Photo> searchPhotoById(Long id) { //example with uri builder and headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri)
                .queryParam("id", id);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<Photo[]> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                Photo[].class);
        return Arrays.asList(response.getBody());
    }

    public void updatePhoto(Photo photo) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", "1");

        restTemplate.put(uri+"/{id}", photo, params);
    }



    public URI createPhoto(Photo photo) {
        return restTemplate.postForLocation(uri, photo, String.class);
    }

    public void deletePhotoById(Long id) {
        restTemplate.delete(uri+"/{id}", id);
    }


}
