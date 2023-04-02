package msu.jaba_prak.DAO;

import msu.jaba_prak.models.Client;
import msu.jaba_prak.models.History;

import java.util.List;
public interface HistoryDAO extends ParentDAO<History, Long>{
    List<History> historyOfClient(Client client);
}
