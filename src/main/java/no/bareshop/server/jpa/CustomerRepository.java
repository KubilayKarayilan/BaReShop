package no.bareshop.server.jpa;

import no.bareshop.server.Customer.CDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by kubilay on 03.05.2015.
 */

public interface CustomerRepository extends CrudRepository<CDao, Long> {

    @Override
    CDao save(CDao entity);

    @Override
    public CDao findOne(Long aLong);

    @Override
    public boolean exists(Long aLong);

    @Override
    public Iterable<CDao> findAll();

    @Override
    public Iterable<CDao> findAll(Iterable<Long> longs);

    @Override
    public long count();

    @Override
    public void delete(Long aLong);

    @Override
    public void delete(CDao entity);

    @Override
    public void delete(Iterable<? extends CDao> entities);

    @Override
    public void deleteAll();
}
