package be.kdg.programming3.repository;

import be.kdg.programming3.domain.Obstacle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import java.util.List;

@Repository
public class StaticListObstacleRepository implements ObstacleRepository {
    private Logger LOG = LoggerFactory.getLogger(StaticListObstacleRepository.class);
    private static List<Obstacle> obstacles = new ArrayList<>();

    @Override
    public Obstacle createObstacle(Obstacle obstacle) {
        //add logs
        obstacles.add(obstacle);
        obstacle.setObstacleId(obstacles.indexOf(obstacle) + 1);
        return obstacle;
    }

    @Override
    public Obstacle findObstacleByObstacleId(int obstacleId) {
        //add catching an error and logs
        Obstacle obstacle = obstacles.get(obstacleId - 1);
        return obstacle;
    }

    @Override
    public List<Obstacle> findAllObstacles() {
        return new ArrayList<>(obstacles);
    }
}

