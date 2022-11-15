package com.springapp.rectangle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Figurecalc {
    @GetMapping("/calculate")
    public int calculate (@RequestParam String figure, @RequestParam int siteA, @RequestParam int siteB, @RequestParam ( required = false)int siteC) { //przy prostokoacie dlugosc =c nie wymagana
if(figure.equalsIgnoreCase("RECTANGLE")) {
    return 2 * siteA + 2 * siteB;
}
else if (figure.equalsIgnoreCase("TRIANGLE")){
    return siteA + siteB +siteC;
}
return 0;
    }
}
