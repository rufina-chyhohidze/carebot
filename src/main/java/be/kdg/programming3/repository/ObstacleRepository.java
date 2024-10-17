package be.kdg.programming3.repository;

import be.kdg.programming3.domain.Obstacle;

import java.util.List;

public interface ObstacleRepository {
    Obstacle createObstacle(Obstacle obstacle);

    Obstacle findObstacleByObstacleId(int obstacleId);

    List<Obstacle> findAllObstacles();
}
