package by.jrr.fp.photos.repository;


import by.jrr.fp.photos.bean.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface PhotoRepository extends JpaRepository<Photo, Long> {
//    http://localhost:8080/photos/search/findAllByTitleContains?firstName=officia
    List<Photo> findAllByTitleContains(String title);
}
