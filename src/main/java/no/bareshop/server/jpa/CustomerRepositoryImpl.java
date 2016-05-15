package no.bareshop.server.jpa;

import no.bareshop.server.Customer.CDao;
import org.springframework.stereotype.Repository;

/**
 * Created by kubilay on 15.05.2016.
 */
@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public CDao save(CDao entity) {
        return null;
    }

    @Override
    public <S extends CDao> Iterable<S> save(Iterable<S> entities) {
        return null;
    }

    @Override
    public CDao findOne(Long aLong) {
        return null;
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public Iterable<CDao> findAll() {
        return null;
    }

    @Override
    public Iterable<CDao> findAll(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void delete(CDao entity) {

    }

    @Override
    public void delete(Iterable<? extends CDao> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
