package com.springapp.rectangle;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class RectangleGui extends VerticalLayout {
    private RectangleRepo rectangleRepo; //wstrzykuje rectrepo


    private TextField textFieldHeight;
    private TextField textFieldWidth;
    private Button button;
    @Autowired
    public RectangleGui(RectangleRepo rectangleRepo) {  //przekazuje rectanglerepo jako parametre i zapisuje do zmiennej, instancja rectrepo bedzie wstrzykiwana do lokalnego pola repo..
        this.rectangleRepo =rectangleRepo;
        textFieldHeight = new TextField("Podaj wysokosc"); // tworze i inicjalizuje 3 obiekty
        textFieldWidth = new TextField("Podaj szerokosc");
        button = new Button("Dodaj!");


        button.addClickListener(ClickEvent -> addRectangle());
        add(textFieldHeight);
        add(textFieldWidth);
        add(button);

    }

    public void addRectangle() {
    Rectangle rectangle = new Rectangle(); //zapisanie obiektu do rectangle
    rectangle.setHeight(Integer.parseInt(textFieldHeight.getValue())); //ze stringa do int  ,JESLI NIE PODAMY ZADNEJ WARTOSCI APLIKACA WPISZE NULLA DO POLA, DO TYPU PORSTEGO NIE JESTW STANIE PRZYPISAC ZADNEJ WARTOSCI, A GDY JEST INT MOZE PRZYPISAC NULL
        rectangle.setWidth(Integer.parseInt(textFieldWidth.getValue())); //ze stringa do int
    rectangleRepo.save(rectangle); //zapisanie do db
    }
}
