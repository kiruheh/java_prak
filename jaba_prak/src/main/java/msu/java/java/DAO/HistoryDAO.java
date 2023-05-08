package msu.java.java.DAO;


import msu.java.java.model.Client;
import msu.java.java.model.History;
import msu.java.java.model.Service;

import java.util.List;
public interface HistoryDAO extends ComonDAO<History, Long>{
    List<History> historyOfClient(Client client);
}
