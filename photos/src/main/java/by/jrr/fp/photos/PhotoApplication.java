package by.jrr.fp.photos;

import by.jrr.fp.photos.bean.Album;
import by.jrr.fp.photos.bean.Photo;
import by.jrr.fp.photos.client.AlbumClient;
import by.jrr.fp.photos.client.PhotoClient;
import by.jrr.fp.photos.repository.AlbumRepository;
import by.jrr.fp.photos.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class PhotoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(PhotoApplication.class, args);

		PhotoClient photoClient = ctx.getBean(PhotoClient.class);
		AlbumClient albumClient = ctx.getBean(AlbumClient.class);
		PhotoRepository photoRepository = ctx.getBean(PhotoRepository.class);
		AlbumRepository albumRepository = ctx.getBean(AlbumRepository.class);

		Iterable<Photo> photos = photoClient.getPhotos();
		photoRepository.saveAll(photos);

		Iterable<Album> albums = albumClient.getAlbums();
		albumRepository.saveAll(albums);
	}
}
