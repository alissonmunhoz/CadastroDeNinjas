package dev.munhoz.CastrroDeNinjas.Ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {
    public  NinjaModel map(NinjaDTO ninjaDTO) {
        NinjaModel ninjaModel = new NinjaModel();
         ninjaModel.setId(ninjaDTO.getId());
         ninjaModel.setName(ninjaDTO.getName());
         ninjaModel.setEmail(ninjaDTO.getEmail());
         ninjaModel.setAge(ninjaDTO.getAge());
         ninjaModel.setImageUrl(ninjaDTO.getImageUrl());
         ninjaModel.setMissoes(ninjaDTO.getMissoes());

         return ninjaModel;
    }

    public NinjaDTO map(NinjaModel ninjaModel) {
        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setName(ninjaModel.getName());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setAge(ninjaModel.getAge());
        ninjaDTO.setImageUrl(ninjaModel.getImageUrl());
        ninjaDTO.setMissoes(ninjaModel.getMissoes());

        return ninjaDTO;

    }

}
