package msu.java.java.DAO.impl;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import msu.java.java.DAO.ServiceDAO;
import msu.java.java.model.Service;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public class ServiceDAOimpl extends ComonDAOimpl<Service, Long> implements ServiceDAO {

    public ServiceDAOimpl() {
        super(Service.class);
    }

    @Override
    public Service getServiceByName(String service_name) {
        for(Service service : getAll())
            if (service.getName().equals(service_name))
                return service;
        return null;
    }




    @Override
    public List<Service> getByFilter(Filter filter) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = (CriteriaBuilder) session.getCriteriaBuilder();
            CriteriaQuery<Service> criteriaQuery = builder.createQuery(Service.class);
            Root<Service> root = criteriaQuery.from(Service.class);

            List<jakarta.persistence.criteria.Predicate> predicates = new ArrayList<>();
            if (filter.getName() != null)
                predicates.add(builder.like(root.get("name"), '%' + filter.getName() + '%'));

            if (predicates.size() != 0)
                criteriaQuery.where(predicates.toArray(new jakarta.persistence.criteria.Predicate[0]));

            return session.createQuery(criteriaQuery).getResultList();
        }
    }

}
