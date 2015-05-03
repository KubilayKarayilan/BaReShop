package jpa;

import Customer.CDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kubilay on 03.05.2015.
 */

public interface CustomerService {

    CDao getCustomer(Long cid);
    void saveCustomer(CDao customer);
    void deleteCustomer(Long cid);
}
