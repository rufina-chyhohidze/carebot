package be.kdg.programming3.service;

import be.kdg.programming3.domain.Obstacle;

import java.util.List;

public interface ObstacleService {
    void addObstacle(int obstacleId);

    List<Obstacle> getAllObstacles();
}
