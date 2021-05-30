package by.jrr.fp.photos.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
//todo: add albums
public class Photo {
    @Id
    @GeneratedValue
    Long Id;
    Long albumId;
    String title;
    String url;
    String thumbnailUrl;
}
