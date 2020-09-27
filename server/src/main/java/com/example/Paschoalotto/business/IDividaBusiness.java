package com.example.Paschoalotto.business;

import com.example.Paschoalotto.model.Divida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface IDividaBusiness {

    ResponseEntity<Divida> buscarPorId(Long id);

    Page<Divida> pesquisar(Pageable pageable);

    ResponseEntity<Divida> salvar(Divida divida);

    ResponseEntity<Divida> alterar(Divida divida, Long id);

    ResponseEntity<?> excluir(Long id);
}
