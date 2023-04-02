package msu.jaba_prak.DAO.impl;
import jakarta.persistence.Query;
import msu.jaba_prak.DAO.HistoryDAO;
import msu.jaba_prak.models.Client;
import msu.jaba_prak.models.History;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class HistoryDAOimpl extends ParentDAOimpl<History, Long> implements HistoryDAO {

    public HistoryDAOimpl() {
        super(History.class);
    }

    @Override
    public List<History> historyOfClient(Client client){
        List<History> his = new ArrayList<>();
        for(History history : getAll())
            if (history.getClient().getId().equals(client.getId()))
                his.add(history);

        return his;
    }

}
