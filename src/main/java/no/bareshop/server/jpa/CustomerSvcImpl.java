package no.bareshop.server.jpa;

import no.bareshop.server.Customer.CDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by kubilay on 03.05.2015.
 */

@Service
public class CustomerSvcImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

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
