package msu.jaba_prak.DAO.impl;
import jakarta.persistence.Query;
import msu.jaba_prak.DAO.HistoryDAO;
import msu.jaba_prak.models.History;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HistoryDAOimpl extends ParentDAOimpl<History, Long> implements HistoryDAO {

    public HistoryDAOimpl() {
        super(History.class);
    }

    @Override
    public List<History> historyOfClient(Long client_id){
        try (Session session = sessionFactory.openSession()){
            Query query = session.createQuery(
                    "FROM History WHERE 'client_id' LIKE :gotID", History.class)
                    .setParameter("gotID", percents(client_id));
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    private String percents(Long input){
        String s = "%" + input + "%";
        return s;
    }
}
