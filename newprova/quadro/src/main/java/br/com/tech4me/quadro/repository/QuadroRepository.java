package br.com.tech4me.quadro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tech4me.quadro.model.Quadro;

@Repository
public interface QuadroRepository extends JpaRepository <Quadro, String>  {
    
}
