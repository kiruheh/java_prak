package msu.java.java.DAO;

import lombok.Builder;
import lombok.Getter;
import msu.java.java.model.Client;
import msu.java.java.model.Service;

import java.util.List;

public interface ClientDAO extends ComonDAO<Client, Long>{
   List<Client> getAllByService(Service service);

   @Builder
   @Getter
   class Filter {
      private Long id;
      private Service service_id;
      private String login;
      private String password;
      private String f_name;
      private String s_name;
      private String passport;
      private String phone;
      private Long balance;
      private Long level;
      private Boolean exist;

   }

}
