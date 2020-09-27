package com.example.Paschoalotto.business;

import com.example.Paschoalotto.model.Divida;
import com.example.Paschoalotto.repository.DividaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DividaBusiness implements IDividaBusiness {

    @Autowired
    DividaRepository dividaRepository;

    public ResponseEntity<Divida> salvar(Divida obj) {
        Divida reg = this.dividaRepository.save(obj);
        return ResponseEntity.ok().body(reg);
    }

    public ResponseEntity<Divida> alterar(Divida obj, Long id) {
        return this.dividaRepository.findById(id)
                .map(reg -> {
                    obj.setId(reg.getId());
                    reg = obj;
                    Divida entidade = this.dividaRepository.save(reg);
                    return ResponseEntity.ok().body(entidade);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Divida> buscarPorId(Long id) {
        return this.dividaRepository.findById(id)
                .map(reg -> ResponseEntity.ok().body(reg))
                .orElse(ResponseEntity.notFound().build());
    }


    public Page<Divida> pesquisar(Pageable pageable) {
        return this.dividaRepository.findAll(pageable);
    }

    public ResponseEntity<?> excluir(Long id) {
        return this.dividaRepository.findById(id)
                .map(record -> {
                    this.dividaRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());

    }
}
