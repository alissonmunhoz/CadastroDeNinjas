package dev.munhoz.CastrroDeNinjas.Ninjas;

import dev.munhoz.CastrroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_cadastro")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(unique = true)
    private String email;
    private int age;

    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;





}
