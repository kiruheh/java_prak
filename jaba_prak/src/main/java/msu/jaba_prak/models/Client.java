package msu.jaba_prak.models;


import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "client")
@Getter
@Setter
@ToString
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor

public class Client implements CommonEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Long id;

    @Column(nullable = false, name = "service_id")
    @ManyToOne(fetch = FetchType.EAGER)
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
    private int balance;

    @Column(nullable = false, name = "level")
    @NonNull
    private int level;

    @Column(nullable = false, name = "exist")
    @NonNull
    private boolean exist;
}


