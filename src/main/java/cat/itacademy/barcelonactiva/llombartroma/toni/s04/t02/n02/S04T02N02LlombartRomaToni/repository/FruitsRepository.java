package cat.itacademy.barcelonactiva.llombartroma.toni.s04.t02.n02.S04T02N02LlombartRomaToni.repository;

import cat.itacademy.barcelonactiva.llombartroma.toni.s04.t02.n02.S04T02N02LlombartRomaToni.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitsRepository extends JpaRepository<Fruit, Integer> {
}
