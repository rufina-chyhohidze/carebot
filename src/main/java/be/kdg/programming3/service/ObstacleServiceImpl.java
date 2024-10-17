package be.kdg.programming3.service;

import be.kdg.programming3.domain.Obstacle;
import be.kdg.programming3.repository.ObstacleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObstacleServiceImpl implements ObstacleService {
    private static final Logger LOG = LoggerFactory.getLogger(ObstacleServiceImpl.class);
    private ObstacleRepository obstacleRepository;

    //add loggers

    public ObstacleServiceImpl(ObstacleRepository obstacleRepository) {
        this.obstacleRepository = obstacleRepository;
    }

    @Override
    public void addObstacle(int obstacleId) {
        Obstacle obstacle = new Obstacle(obstacleId);
        obstacleRepository.createObstacle(obstacle);
    }

    @Override
    public List<Obstacle> getAllObstacles() {
        return obstacleRepository.findAllObstacles();
    }
}
