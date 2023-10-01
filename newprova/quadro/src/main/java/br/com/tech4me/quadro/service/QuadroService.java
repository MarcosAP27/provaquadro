package br.com.tech4me.quadro.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.quadro.shared.QuadroCompletoDTO;


public interface QuadroService {
    QuadroCompletoDTO cadastrarQuadro(QuadroCompletoDTO quadro);
    List<QuadroCompletoDTO> obterQuadrosCadastrados();
    Optional<QuadroCompletoDTO> atualizarQuadroPorid(String id, QuadroCompletoDTO quadro);
    Optional<QuadroCompletoDTO> buscarQuadroPorId(String id);
    void excluir(String id);
}
