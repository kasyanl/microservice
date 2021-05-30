package by.jrr.fp.photos.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Album {
    @Id
    @GeneratedValue
    Long id;
    Long userId;
    String title;
}
