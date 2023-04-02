package msu.jaba_prak.DAO;

import msu.jaba_prak.models.Client;
import msu.jaba_prak.models.Service;
import msu.jaba_prak.JabaPrakApplication;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

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
    private SessionFactory sessionFactory;

    @Test
    void testWhoServ(){

        List<Client> clients = clientDAO.getAllByService(serviceDAO.getServiceByName("Testserv"));

        assertEquals(clients.size(), 1);

        
    }

    @BeforeEach
    void beforEach(){


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
                100,
                0,
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
                100000000,
                10,
                false
        ));



        }
    @BeforeAll
    @AfterEach
    void annihilation() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.createNativeQuery("TRUNCATE person RESTART IDENTITY CASCADE;").executeUpdate();
            session.createNativeQuery("ALTER SEQUENCE person_person_id_seq RESTART WITH 1;").executeUpdate();
            session.getTransaction().commit();
        }
    }
}
