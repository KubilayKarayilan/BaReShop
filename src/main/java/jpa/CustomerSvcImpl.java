package jpa;

import Customer.CDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kubilay on 03.05.2015.
 */
public class CustomerSvcImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public CDao getCustomer(Long cid) {
        customerRepository.findOne(cid);
        return null;
    }

    @Override
    public void saveCustomer(CDao customer) {
        customerRepository.save(customer);

    }

    @Override
    public void deleteCustomer(Long cid) {
        customerRepository.delete(cid);
    }
}
