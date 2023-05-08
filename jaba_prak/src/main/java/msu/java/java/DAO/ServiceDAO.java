package msu.java.java.DAO;


import msu.java.java.model.Service;

import org.hibernate.Filter;
import java.util.List;

public interface ServiceDAO extends ComonDAO<Service, Long>{
    public Service getServiceByName(String service_name);
    List<Service> getByFilter(Filter filter);

}
