package msu.jaba_prak.DAO.impl;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import msu.jaba_prak.DAO.ServiceDAO;
import msu.jaba_prak.models.Service;
import org.hibernate.Filter;
import org.hibernate.Session;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ServiceDAOimpl extends ParentDAOimpl<Service, Long> implements ServiceDAO {

    public ServiceDAOimpl(Class<Service> entityClass) {
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
            CriteriaBuilder builder = session.getCriteriaBuilder();
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
