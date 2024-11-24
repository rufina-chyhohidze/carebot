package be.kdg.programming3.repository;

import be.kdg.programming3.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{
    //  The findAll() method is provided by JpaRepository

}
