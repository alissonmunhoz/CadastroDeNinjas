package dev.munhoz.CastrroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;



    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // Listar todos os meus ninjas
    public List<NinjaDTO> listarNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return  ninjas.stream().map(ninjaMapper::map).collect(Collectors.toList());
    }

    public NinjaDTO findNinjaById(Long id) {
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);
        return  ninja.map(ninjaMapper::map).orElse(null);
    }

    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return  ninjaMapper.map(ninja);
    }

    public void deletarNinjaPorId(Long id) {
         ninjaRepository.deleteById(id);
    }

    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninja) {
        Optional<NinjaModel> ninjaExiste = ninjaRepository.findById(id);
        if (ninjaExiste.isPresent()) {
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninja);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return  ninjaMapper.map(ninjaSalvo);
        }

        return  null;
    }
}

