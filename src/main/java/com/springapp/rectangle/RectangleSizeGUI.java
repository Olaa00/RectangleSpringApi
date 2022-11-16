package com.springapp.rectangle;


import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.textfield.TextArea;
import org.springframework.beans.factory.annotation.Autowired;
import com.vaadin.flow.component.textfield.TextField;
import java.awt.*;
import com.vaadin.flow.component.button.Button;
@Route
public class RectangleSizeGUI extends VerticalLayout {

        private RectangleRepo rectangleRepo;
    private TextArea textAreaRectangle;
    private TextField textFieldSize;
    private Button buttonBigger;
    private Button buttonSmaller;

    @Autowired
    public RectangleSizeGUI(RectangleRepo rectangleRepo) {
                this.rectangleRepo = rectangleRepo;
                this.textFieldSize = new TextField("Podaj rozmiar");
                textAreaRectangle = new TextArea("Wynik: ");

                buttonBigger = new Button("Pokaz prostokaty o  wiekszych obwodach ");
              buttonSmaller = new Button("Pokaz prostokaty o  mniejszych obwodach ");



           buttonBigger.addClickListener(clickEvent -> textAreaRectangle.setValue(rectangleRepo.getBigRectangles(Integer.parseInt(textFieldSize.getValue())).toString())); // zapisuje wartosci w textarea, tore sa zgodne z zadaniem <>?
        buttonSmaller.addClickListener(clickEvent -> textAreaRectangle.setValue(rectangleRepo.getSmallRectangle(Integer.parseInt(textFieldSize.getValue())).toString()));



            add(textFieldSize);
            add(buttonBigger);
            add(buttonSmaller);
         add(textAreaRectangle);
    }
}
