package no.bareshop.server.jpa;

import no.bareshop.server.Customer.CDao;
import org.springframework.stereotype.Component;

/**
 * Created by kubilay on 03.05.2015.
 */

public interface CustomerService {

    CDao getCustomer(Long cid);
    void saveCustomer(CDao customer);
    void deleteCustomer(Long cid);
}
