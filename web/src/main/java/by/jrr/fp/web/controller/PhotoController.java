package by.jrr.fp.web.controller;

import by.jrr.fp.web.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PhotoController {

    @Autowired
    PhotoService photoService;

    @GetMapping("/photo")
    public ModelAndView openPhoto() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("photo");

        modelAndView.addObject("title", "Photos");
        modelAndView.addObject("photos", photoService.findAll());

        return modelAndView;
    }
    @GetMapping("/album")
    public ModelAndView openAlbum() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("photo");

        modelAndView.addObject("title", "Photos");
        modelAndView.addObject("photos", photoService.findAll());

        return modelAndView;
    }
}
