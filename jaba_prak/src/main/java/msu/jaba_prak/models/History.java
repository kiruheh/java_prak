package msu.jaba_prak.models;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "history")
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class History implements CommonEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Long id;

    @Column(nullable = false, name = "client_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @NonNull
    @ToString.Exclude
    private Client client;

    @Column(nullable = false, name = "money_change")
    private Long money;

    @Column(nullable = false, name="date")
    private Long date;
}


