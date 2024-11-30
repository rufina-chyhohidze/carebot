package be.kdg.programming3.service;

import be.kdg.programming3.domain.Obstacle;
import be.kdg.programming3.repository.ObstacleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObstacleServiceImpl implements ObstacleService {
    private static final Logger LOG = LoggerFactory.getLogger(ObstacleServiceImpl.class);
    private final ObstacleRepository obstacleRepository;

    public ObstacleServiceImpl(ObstacleRepository obstacleRepository) {
        this.obstacleRepository = obstacleRepository;
    }

    @Override
    public void addObstacle(Obstacle obstacle) {
        LOG.info("Adding new obstacle: {}", obstacle);
        obstacleRepository.save(obstacle);
        LOG.info("Obstacle saved successfully.");
    }


    @Override
    public List<Obstacle> getAllObstacles() {
        LOG.info("Fetching all obstacles from the database");
        List<Obstacle> obstacles = obstacleRepository.findAll();
        LOG.info("Fetched obstacles: {}", obstacles);
        return obstacles;
    }

    @Override
    public Obstacle getObstacleById(Long obstacleId) {
        LOG.info("Fetching obstacle with id: {}", obstacleId);
        Optional<Obstacle> optionalObstacle = obstacleRepository.findById(obstacleId);
        return optionalObstacle.orElse(null);
    }

//    @Override
//    @GetMapping("/obstacleId")
//    public Obstacle findObstacleById(Long obstacleId) {
//        LOG.info("Fetching obstacle with id: {}", obstacleId);
//        return obstacleRepository.findById((long) obstacleId);
//    }
}
