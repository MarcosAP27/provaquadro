package br.com.tech4me.quadro.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.tech4me.quadro.model.Quadro;
import br.com.tech4me.quadro.repository.QuadroRepository;
import br.com.tech4me.quadro.shared.QuadroCompletoDTO;



@Service
public class QuadroServiceImpl implements QuadroService {
    @Autowired
    private QuadroRepository repositorio;
    
    @Override
    public QuadroCompletoDTO cadastrarQuadro(QuadroCompletoDTO dto) {
        Quadro quadro = new Quadro(dto);
        quadro = repositorio.save(quadro);
        return new QuadroCompletoDTO(quadro.getId(), quadro.getNomeQuadro(), quadro.getValor());
    }

    @Override
    public List<QuadroCompletoDTO> obterQuadrosCadastrados() {
        return repositorio.findAll().stream().map(q -> QuadroCompletoDTO.fromQuadroCompleto(q)).toList();

    }

    @Override
    public Optional<QuadroCompletoDTO> atualizarQuadroPorid(String id, QuadroCompletoDTO quadro) {
        Optional<Quadro> quad = repositorio.findById(id);
        if (quad.isPresent()) {
            Quadro quadroAtualizado = quad.get();
            quadroAtualizado.setNomeQuadro(quadro.nomeQuadro());
            quadroAtualizado.setValor(quadro.valor());
            Quadro quadroSalvo = repositorio.save(quadroAtualizado);
            return Optional.of(QuadroCompletoDTO.fromQuadroCompleto(quadroSalvo));
        }
        return Optional.empty();
    }

    @Override
    public Optional<QuadroCompletoDTO> buscarQuadroPorId(String id) {
        Optional<Quadro> quadro = repositorio.findById(id);
        if (quadro.isPresent()) {
           return Optional.of(QuadroCompletoDTO.fromQuadroCompleto(quadro.get()));
        }
        return Optional.empty();
    }

    @Override
    public void excluir(String id) {
        repositorio.deleteById(id);
    }

}
