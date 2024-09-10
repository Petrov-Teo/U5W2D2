package PetrovTodor.SpringWebEsercizi.controllers;

import PetrovTodor.SpringWebEsercizi.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autors")
public class AutorController {

    @Autowired
    private AutorService autorService;


}
