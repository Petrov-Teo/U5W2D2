package PetrovTodor.SpringWebEsercizi.controllers;

import PetrovTodor.SpringWebEsercizi.entities.AutorePost;
import PetrovTodor.SpringWebEsercizi.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
1. GET http://localhost:3001/autors
2. POST http://localhost:3001/autors (+ body)
3. GET  http://localhost:3001/autors/{autoreId}
4. PUT http://localhost:3001/autors/{autoreId}


 */


@RestController
@RequestMapping("/autors")
public class AutorController {

    @Autowired
    private AutorService autorService;

    // 1. GET http://localhost:3001/autors
    @GetMapping
    private List<AutorePost> getAllAutors() {
        return autorService.findAll();
    }

    // 2. POST http://localhost:3001/autors (+ body)
    @PostMapping
    private AutorePost createAutore(@RequestBody AutorePost body) {
        return autorService.saveAutorePost(body);
    }

    // 3. GET  http://localhost:3001/autors/{autoreId}

    @GetMapping("/{autoreId}")
    private AutorePost getAutorePostById(@PathVariable int autoreId) {
        return autorService.findById(autoreId);
    }

    //4. PUT http://localhost:3001/autors/{autoreId}
    @PutMapping("/{autoreId}")
    private AutorePost findByIdAndUpdate(@PathVariable int autoreId, @RequestBody AutorePost body) {
        return autorService.findByIdAndUpdate(autoreId, body);
    }
    //5. DELETE http://localhost:3001/autors/{autoreId}

    @DeleteMapping("/{autoreId}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void findByIdAndDelete(@PathVariable int autoreId) {
        autorService.findByIdAndDelete(autoreId);
    }
}
