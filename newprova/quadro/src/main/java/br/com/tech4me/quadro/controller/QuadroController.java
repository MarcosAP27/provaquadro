package br.com.tech4me.quadro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.quadro.service.QuadroService;
import br.com.tech4me.quadro.shared.QuadroCompletoDTO;

@RestController
@RequestMapping("/quadros")
public class QuadroController {
    @Autowired
    private QuadroService servico;

    // CREATE
    @PostMapping
    public ResponseEntity<QuadroCompletoDTO> cadastrarQuadro(@RequestBody QuadroCompletoDTO dto) {
        return new ResponseEntity<>(servico.cadastrarQuadro(dto), HttpStatus.CREATED);
    }

    // READ
    @GetMapping
    public ResponseEntity<List<QuadroCompletoDTO>> buscarQuadrosCadastrados() {
        return new ResponseEntity<>(servico.obterQuadrosCadastrados(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuadroCompletoDTO> buscarPorId(@PathVariable String id) {
        Optional<QuadroCompletoDTO> quadroDto = servico.buscarQuadroPorId(id);
        
        if (quadroDto.isPresent()) {
           return new ResponseEntity<>(quadroDto.get(), HttpStatus.OK);
        } else {
           
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<QuadroCompletoDTO> atualizandoQuadro(@PathVariable String id,
                                                            @RequestBody QuadroCompletoDTO dto) {
        Optional<QuadroCompletoDTO> quadroNovo = servico.atualizarQuadroPorid(id, dto);
        if (quadroNovo.isPresent()) {
            return new ResponseEntity<>(quadroNovo.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<QuadroCompletoDTO> excluirQuadro(@PathVariable String id) {
        servico.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
