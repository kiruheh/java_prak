package msu.java.java.DAO.impl;

import msu.java.java.DAO.ClientDAO;
import msu.java.java.model.Client;
import msu.java.java.model.Service;


import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
@Repository

public class ClientDAOimpl extends ComonDAOimpl<Client, Long> implements ClientDAO {


    public ClientDAOimpl() {
        super(Client.class);
    }

    @Override
    public List<Client> getAllByService(Service service) {

        List<Client> ret = new ArrayList<>();
        for(Client client : getAll())
            if (client.getService_id().getName().equals(service.getName()))
                ret.add(client);
        return ret;
    }

}
