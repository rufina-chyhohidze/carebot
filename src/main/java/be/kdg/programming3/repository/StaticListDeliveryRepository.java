//package be.kdg.programming3.repository;
//
////import be.kdg.programming3.database.DataBase;
//import be.kdg.programming3.domain.Delivery;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.repository.query.FluentQuery;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.function.Function;
//
//@Repository
//public class StaticListDeliveryRepository implements DeliveryRepository {
//    private Logger LOG = LoggerFactory.getLogger(StaticListDeliveryRepository.class);
//    private static List<Delivery> deliveries = new ArrayList<>();
//
//    @Override
//    public Delivery createDelivery(Delivery delivery) {
//        LOG.info("Creating new delivery {}", delivery);
//        deliveries.add(delivery);
//        delivery.setDeliveryId(deliveries.indexOf(delivery) + 1);
//        return delivery;
//    }
//
//
//    @Override
//    public Delivery findDeliveryByDeliveryId(int deliveryId) {
//        LOG.info("Finding delivery with id {}", deliveryId);
//
//        try {
//            Delivery delivery = deliveries.get(deliveryId - 1);
//            LOG.info("Found delivery {}", delivery);
//            return delivery;
//        } catch (IndexOutOfBoundsException e) {
//            LOG.error("Could not find delivery with id {}", deliveryId, e);
//            throw new IllegalArgumentException("Could not find delivery with id " + deliveryId);
//        }
//    }
//
//
//    @Override
//    public List<List<String>> findAllDeliveries() {
//        LOG.info("Finding all deliveries");
//        return new ArrayList<>(DataBase.getObstacles());
//    }
//
//    @Override
//    public void flush() {
//
//    }
//
//    @Override
//    public <S extends Delivery> S saveAndFlush(S entity) {
//        return null;
//    }
//
//    @Override
//    public <S extends Delivery> List<S> saveAllAndFlush(Iterable<S> entities) {
//        return List.of();
//    }
//
//    @Override
//    public void deleteAllInBatch(Iterable<Delivery> entities) {
//
//    }
//
//    @Override
//    public void deleteAllByIdInBatch(Iterable<Integer> integers) {
//
//    }
//
//    @Override
//    public void deleteAllInBatch() {
//
//    }
//
//    @Override
//    public Delivery getOne(Integer integer) {
//        return null;
//    }
//
//    @Override
//    public Delivery getById(Integer integer) {
//        return null;
//    }
//
//    @Override
//    public Delivery getReferenceById(Integer integer) {
//        return null;
//    }
//
//    @Override
//    public <S extends Delivery> Optional<S> findOne(Example<S> example) {
//        return Optional.empty();
//    }
//
//    @Override
//    public <S extends Delivery> List<S> findAll(Example<S> example) {
//        return List.of();
//    }
//
//    @Override
//    public <S extends Delivery> List<S> findAll(Example<S> example, Sort sort) {
//        return List.of();
//    }
//
//    @Override
//    public <S extends Delivery> Page<S> findAll(Example<S> example, Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public <S extends Delivery> long count(Example<S> example) {
//        return 0;
//    }
//
//    @Override
//    public <S extends Delivery> boolean exists(Example<S> example) {
//        return false;
//    }
//
//    @Override
//    public <S extends Delivery, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
//        return null;
//    }
//
//    @Override
//    public <S extends Delivery> S save(S entity) {
//        return null;
//    }
//
//    @Override
//    public <S extends Delivery> List<S> saveAll(Iterable<S> entities) {
//        return List.of();
//    }
//
//    @Override
//    public Optional<Delivery> findById(Integer integer) {
//        return Optional.empty();
//    }
//
//    @Override
//    public boolean existsById(Integer integer) {
//        return false;
//    }
//
//    @Override
//    public List<Delivery> findAll() {
//        return List.of();
//    }
//
//    @Override
//    public List<Delivery> findAllById(Iterable<Integer> integers) {
//        return List.of();
//    }
//
//    @Override
//    public long count() {
//        return 0;
//    }
//
//    @Override
//    public void deleteById(Integer integer) {
//
//    }
//
//    @Override
//    public void delete(Delivery entity) {
//
//    }
//
//    @Override
//    public void deleteAllById(Iterable<? extends Integer> integers) {
//
//    }
//
//    @Override
//    public void deleteAll(Iterable<? extends Delivery> entities) {
//
//    }
//
//    @Override
//    public void deleteAll() {
//
//    }
//
//    @Override
//    public List<Delivery> findAll(Sort sort) {
//        return List.of();
//    }
//
//    @Override
//    public Page<Delivery> findAll(Pageable pageable) {
//        return null;
//    }
//}
