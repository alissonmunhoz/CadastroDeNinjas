package dev.munhoz.CastrroDeNinjas.Ninjas;

import dev.munhoz.CastrroDeNinjas.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private Long id;
    private String name;
    private String email;
    private int age;
    private String imageUrl;
    private MissoesModel missoes;

}
