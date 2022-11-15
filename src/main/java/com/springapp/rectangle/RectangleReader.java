package com.springapp.rectangle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
public class RectangleReader {

    private RectangleRepo rectangleRepo; //instancja
@Autowired
    public RectangleReader(RectangleRepo rectangleRepo) { //konstruktor zeby wstrzyknac instacje repo do tej klasy
        this.rectangleRepo = rectangleRepo;
    }

    @Value("${siteA1}") //adnotacja value pozwala wstrzyknac z pliku kofiguracyjnego do pola na ktorym sie ta adnotacja znajduje
       private int siteA1; //dowolona nazwa
    @Value("${siteB1}")
        private int siteB1;
    @Value("${siteA2}")
        private int siteA2;
    @Value("${siteB2}")
        private int siteB2;
    @Value("${siteA3}")
        private int  siteA3;
    @Value("${siteB3}")
        private int siteB3;
    @Value("${siteA4}")
        private int siteA4;
    @Value("${siteB4}")
        private int siteB4;

    @EventListener(ApplicationReadyEvent.class)
    public void addRectangles() {
        Rectangle rectangle1 = new Rectangle(siteA1,siteB1); //zgodnie z  konstruktorem przymuje wysokosc, szerokosc
        Rectangle rectangle2 = new Rectangle(siteA2,siteB2);
        Rectangle rectangle3 = new Rectangle(siteA3,siteB3);
        Rectangle rectangle4 = new Rectangle(siteA4,siteB4);
        rectangleRepo.save(rectangle1);
        rectangleRepo.save(rectangle2);
        rectangleRepo.save(rectangle3);
        rectangleRepo.save(rectangle4);
        System.out.println("Zapis do DB prostokatow o okreslonych wymiarach");
    }
    }
