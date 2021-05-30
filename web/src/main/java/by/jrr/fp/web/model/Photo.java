package by.jrr.fp.web.model;

import lombok.Data;

@Data
//todo: add albums
public class Photo {
    Long id;
    Long albumId;
    String title;
    String url;
    String thumbnailUrl;
}
