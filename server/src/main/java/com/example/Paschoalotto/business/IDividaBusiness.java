package com.example.Paschoalotto.business;

import com.example.Paschoalotto.dtos.DividaDTO;
import com.example.Paschoalotto.model.Divida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface IDividaBusiness {

    ResponseEntity<DividaDTO> buscarPorId(Long id);

    Page<DividaDTO> pesquisar(Pageable pageable);

    ResponseEntity<DividaDTO> salvar(DividaDTO divida);

    ResponseEntity<DividaDTO> alterar(DividaDTO divida, Long id);

    ResponseEntity<?> excluir(Long id);
}
