package com.springapp.rectangle;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface RectangleRepo extends CrudRepository <Rectangle, Long>{
    @Query(nativeQuery = true, value = "SELECT * FROM RECTANGLE rect WHERE (2*rect.height +2* rect.width) >=  20  ")  //ALIAS rect
    List<Rectangle> getBigRectangles(@Param ("size") int size); // zwracamy lista prostokatow gdzie obwod >= 20 , wyswietla elemnty mniejsze od ktorych zadan lub wieksze

    @Query(nativeQuery = true, value = "SELECT * FROM RECTANGLE rect WHERE (2*rect.height +2* rect.width) <  20  ")
    List<Rectangle> getSmallRectangle(@Param ("size") int size);
}
