package br.com.tech4me.quadro.shared;

import br.com.tech4me.quadro.model.Quadro;

public record QuadroCompletoDTO(String id, String nomeQuadro, Double valor) {
    public static QuadroCompletoDTO fromQuadroCompleto(Quadro quadro){
        return new QuadroCompletoDTO(quadro.getId(), quadro.getNomeQuadro(), quadro.getValor());
}
}