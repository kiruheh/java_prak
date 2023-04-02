package msu.jaba_prak.DAO.impl;

import msu.jaba_prak.DAO.ClientDAO;
import msu.jaba_prak.models.Client;
import msu.jaba_prak.models.Service;


import org.hibernate.Session;
import org.hibernate.query.Query;


import java.util.List;

public class ClientDAOimpl extends ParentDAOimpl<Client, Long> implements ClientDAO {


    public ClientDAOimpl(Class<Client> entityClass) {
        super(Client.class);
    }

    @Override
    public List<Client> getAllByService(Service service) {
        try (Session session = sessionFactory.openSession()) {
            Query<Client> query = session.createQuery("FROM Client WHERE 'service_id' LIKE :gotID", Client.class)
                    .setParameter("gotID", '%' + service.getId().toString() + '%');
            return query.getResultList().size() == 0 ? null : query.getResultList();

        }
    }

}
