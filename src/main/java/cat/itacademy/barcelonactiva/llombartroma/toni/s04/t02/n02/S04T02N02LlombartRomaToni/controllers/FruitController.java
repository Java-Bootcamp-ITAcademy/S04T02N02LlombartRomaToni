package cat.itacademy.barcelonactiva.llombartroma.toni.s04.t02.n02.S04T02N02LlombartRomaToni.controllers;

import cat.itacademy.barcelonactiva.llombartroma.toni.s04.t02.n02.S04T02N02LlombartRomaToni.domain.Fruit;
import cat.itacademy.barcelonactiva.llombartroma.toni.s04.t02.n02.S04T02N02LlombartRomaToni.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class FruitController {
    @Autowired
    private FruitService fruitService;
    /* Handles adding fruits requests */
    @PostMapping(value={"/fruit/add","/fruit/add/"})
    public ResponseEntity<Fruit> add(@RequestBody Fruit fruit) {
        try {
            Optional<Fruit> optionalFruit = fruitService.add(fruit);
            if(optionalFruit.isPresent()) {
                return new ResponseEntity<>(optionalFruit.get(), HttpStatus.CREATED);
            }
            else {
                throw new FruitNotFoundException();
            }
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    /* Handles updating fruits requests */
    @PutMapping(value={"/fruit/update/{id}","/fruit/update/{id}/"})
    public ResponseEntity<Fruit> update(@RequestBody Fruit newFruit, @PathVariable int id) {
        try {
            Optional<Fruit> optionalFruit = fruitService.update(newFruit, id);
            if(optionalFruit.isPresent()) {
                return new ResponseEntity<>(optionalFruit.get(), HttpStatus.CREATED);
            } else {
                throw new FruitNotFoundException();
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    /* Handles deleting fruits requests */
    @DeleteMapping(value={"/fruit/delete/{id}","/fruit/delete/{id}/"})
    public ResponseEntity<Fruit> delete(@PathVariable int id) {
        try {
            Optional<Fruit> optionalFruit = fruitService.delete(id);
            if(optionalFruit.isPresent()) {
                return new ResponseEntity<>(optionalFruit.get(), HttpStatus.OK);
            }
            else {
                throw new FruitNotFoundException();
            }
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    /* Handles retrieving one fruit requests */
    @GetMapping(value={"/fruit/getOne/{id}","/fruit/getOne/{id}/"})
    public ResponseEntity<Fruit> getOne(@PathVariable int id) {
        Optional<Fruit> optionalFruit = fruitService.getOne(id);
        try {
            if(optionalFruit.isPresent()) {
                return new ResponseEntity<>(optionalFruit.get(),HttpStatus.OK);
            }
            else {
                throw new FruitNotFoundException();
            }
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    /* Handles retrieving all fruits requests */
    @GetMapping(value={"/fruit/getAll","/fruit/getAll/"})
    public ResponseEntity<List<Fruit>> getAll() {
        Optional<List<Fruit>> optionalFruits = fruitService.getAll();
        try {
            if(optionalFruits.isPresent()) {
                return new ResponseEntity<>(optionalFruits.get(), HttpStatus.OK);
            }
            else {
                throw new FruitNotFoundException();
            }
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
