package msu.java.java.model;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "history")
@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor

public class History implements CommonEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Long id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "client_id")
    @NonNull
    @ToString.Exclude
    private Client client;

    @Column(nullable = false, name = "money_change")
    private Long money;

    @Column(nullable = false, name="date")
    private Long date;
}


