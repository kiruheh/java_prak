package msu.jaba_prak.DAO;

import msu.jaba_prak.models.Service;

import org.hibernate.Filter;
import java.io.File;
import java.util.List;

public interface ServiceDAO extends ParentDAO<Service, Long>{
    public Service getServiceByName(String service_name);
    List<Service> getByFilter(Filter filter);

}
