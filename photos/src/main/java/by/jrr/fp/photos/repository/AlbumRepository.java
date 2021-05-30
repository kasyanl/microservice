package by.jrr.fp.photos.repository;


import by.jrr.fp.photos.bean.Album;
import by.jrr.fp.photos.bean.Photo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource
public interface AlbumRepository extends JpaRepository<Album, Long> {
    Page<Album> findAllByTitleContains(String title, Pageable pageable);
    Page<Album> findAllByUserIdContains(String title, Pageable pageable);
}
