package msu.java.java.DAO;
import msu.java.java.model.Client;
import msu.java.java.model.History;
import msu.java.java.model.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;


import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestPropertySource(locations = "classpath:application.properties")
public class ClientTest {

    @Autowired
    private ClientDAO clientDAO;
    @Autowired
    private ServiceDAO serviceDAO;
    @Autowired
    private HistoryDAO historyDAO;
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Test
    void testWhoServ(){

        List<Client> clients = clientDAO.getAllByService(serviceDAO.getServiceByName("Testserv"));
        assertEquals(clients.size(), 1);

        List<Client> clients_2 = clientDAO.getAllByService(serviceDAO.getServiceByName("X_llimit"));
        assertEquals(clients_2.size(), 2);

        
        List<Client> clients_3 = clientDAO.getAllByService(serviceDAO.getServiceByName("123123123123123"));
        assertNull(clients_3);

        
    }


    @Test
    void testHistory(){

        List<Client> clients = clientDAO.getAllByService(serviceDAO.getServiceByName("Testserv"));
        List<History> histories = historyDAO.getAll().stream().toList();

        assertNull(histories.historyOfClient(clients));


    }

    @Test
    void testService(){
        List<Client> clients = clientDAO.getAllByService(serviceDAO.getServiceByName("Testserv"));
        List<Service> services = serviceDAO.getServiceByName("Testserv");
        List<Service> services_filtred = serviceDAO.getByFilter(filter);

        assertNotNull(services_filtred);
    }
    @BeforeEach
    void beforeEach(){


        List<Service> serviceList = new ArrayList<>();
        serviceList.add(new Service("Testserv", 10L,10L,10L,10L,10L,10L,10L));
        serviceList.add(new Service("Secserv", 20L,10L,20L,10L,0L,0L,0L));



        List<Client> clientList = new ArrayList<>();
        clientList.add(new Client(1337L,
                serviceDAO.getServiceByName("Testserv"),
                "tester",
                "tester228",
                "Test",
                "SHmest",
                "123123123",
                "+74959125317",
                100L,
                0L,
                true
        ));
        clientList.add(new Client(993L,
                serviceDAO.getServiceByName("Secserv"),
                "ghul",
                "tichaminusseven",
                "Ken",
                "Kaneky",
                "4520100099",
                "+78005553535",
                100000000L,
                10L,
                false
        ));



        }
    @BeforeAll
    @AfterEach
    void annihilation() {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()){
            entityManager.getTransaction().begin();
            entityManager.createNativeQuery("TRUNCATE history RESTART IDENTITY CASCADE;").executeUpdate();
            entityManager.createNativeQuery("ALTER SEQUENCE history_id_seq RESTART WITH 1;").executeUpdate();
            entityManager.createNativeQuery("TRUNCATE client RESTART IDENTITY CASCADE;").executeUpdate();
            entityManager.createNativeQuery("ALTER SEQUENCE client_id_seq RESTART WITH 1;").executeUpdate();
            entityManager.createNativeQuery("TRUNCATE service  RESTART IDENTITY CASCADE;").executeUpdate();
            entityManager.createNativeQuery("ALTER SEQUENCE service_id_seq RESTART WITH 1;").executeUpdate();
            entityManager.getTransaction().commit();

        }
    }
}
