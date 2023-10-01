package br.com.tech4me.quadro.model;

import br.com.tech4me.quadro.shared.QuadroCompletoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(schema = "loja", name = "quadro")
public class Quadro {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @JoinColumn(name = "nome_quadro")
    private String nomeQuadro;
    private Double valor;

    public Quadro(){
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeQuadro() {
        return nomeQuadro;
    }

    public void setNomeQuadro(String nomeQuadro) {
        this.nomeQuadro = nomeQuadro;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
     public Quadro(QuadroCompletoDTO dto){
        setId(dto.id());
        setNomeQuadro(dto.nomeQuadro());
        setValor(dto.valor());
    }

}
