package msu.java.java.model;


import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor

public class Client implements CommonEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Long id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "service_id")
    @ToString.Exclude
    private Service service_id;

    @Column(nullable = false, name = "login")
    @NonNull
    private String login;

    @Column(nullable = false, name = "password")
    @NonNull
    private String password;

    @Column(name = "f_name")
    private String f_name;

    @Column(name = "s_name")
    private String s_name;

    @Column(name = "passport")
    private String passport;

    @Column(nullable = false, name = "phone_number")
    @NonNull
    private String phone;

    @Column(nullable = false, name = "balance")
    @NonNull
    private Long balance;

    @Column(nullable = false, name = "level")
    @NonNull
    private Long level;

    @Column(nullable = false, name = "exist")
    @NonNull
    private Boolean exist;
}


