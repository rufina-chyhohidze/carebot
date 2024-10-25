package be.kdg.programming3.repository;

import be.kdg.programming3.domain.Obstacle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObstacleRepository extends JpaRepository<Obstacle, Integer> {

}
