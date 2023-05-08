package msu.java.java.DAO.impl;
import msu.java.java.DAO.HistoryDAO;

import msu.java.java.model.Client;
import msu.java.java.model.History;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HistoryDAOimpl extends ComonDAOimpl<History, Long> implements HistoryDAO {

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
