package msu.jaba_prak.DAO;

import msu.jaba_prak.models.Client;
import msu.jaba_prak.models.History;
import msu.jaba_prak.models.Service;

import java.util.List;

public interface ClientDAO extends ParentDAO<Client, Long>{
   List<Client> getAllByService(Service service);

}
