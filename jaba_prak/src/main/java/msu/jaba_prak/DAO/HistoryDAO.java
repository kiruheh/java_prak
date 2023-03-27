package msu.jaba_prak.DAO;

import msu.jaba_prak.models.History;

import java.util.List;
public interface HistoryDAO extends ParentDAO<History, Long>{
    List<History> historyOfClient(Long client_id);
}
