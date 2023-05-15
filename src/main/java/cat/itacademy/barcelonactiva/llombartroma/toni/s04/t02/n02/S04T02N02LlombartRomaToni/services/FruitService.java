package cat.itacademy.barcelonactiva.llombartroma.toni.s04.t02.n02.S04T02N02LlombartRomaToni.services;


import cat.itacademy.barcelonactiva.llombartroma.toni.s04.t02.n02.S04T02N02LlombartRomaToni.domain.Fruit;
import cat.itacademy.barcelonactiva.llombartroma.toni.s04.t02.n02.S04T02N02LlombartRomaToni.repository.FruitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FruitService {
    @Autowired
    private FruitsRepository fruitsRepository;
    /* Implements how API add a new Fruit */
    public Optional<Fruit> add(Fruit fruit) {
        return Optional.ofNullable(fruitsRepository.save(fruit));
    }
    /* Implements how API updates a Fruit */
    public Optional<Fruit> update(Fruit fruit, int id) {
        Optional<Fruit> optionalFruit = fruitsRepository.findById(id);
        if(optionalFruit.isPresent()) {
            Fruit updatedFruit = optionalFruit.get();
            updatedFruit.setName(fruit.getName());
            updatedFruit.setQuantity(fruit.getQuantity());
            return Optional.ofNullable(fruitsRepository.save(updatedFruit));
        }
        else {
            return Optional.empty();
        }
    }
    /* Implements how API removes a Fruit */
    public Optional<Fruit> delete(int id) {
        Optional<Fruit> optionalFruit = fruitsRepository.findById(id);
        fruitsRepository.deleteById(id);
        return optionalFruit;
    }
    /* Implements how API retrieves a single Fruit */
    public Optional<Fruit> getOne(int id) {
        return fruitsRepository.findById(id);
    }
    /* Implements how API retrieves all Fruits */
    public Optional<List<Fruit>> getAll() {
        return Optional.ofNullable(fruitsRepository.findAll());
    }

}
