package msu.jaba_prak.models;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "service")
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Long id;

    @Column(nullable = false, name = "name")
    @NonNull
    private String name;


    @Column(nullable = false, name = "cost")
    @NonNull
    private Long cost;

    @Column(nullable = false, name = "gb")
    @NonNull
    private Long gb;

    @Column(nullable = false, name = "minutes")
    @NonNull
    private Long minutes;

    @Column(nullable = false, name = "sms")
    @NonNull
    private Long sms;

    @Column(nullable = false, name = "extra_gb_cost")
    @NonNull
    private Long egbc;

    @Column(nullable = false, name = "extra_minutes_cost")
    @NonNull
    private Long eminc;

    @Column(nullable = false, name = "extra_sms_cost")
    @NonNull
    private Long esmsc;

}
