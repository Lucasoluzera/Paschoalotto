package com.example.Paschoalotto.business;

import com.example.Paschoalotto.dtos.DividaDTO;
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

    public ResponseEntity<DividaDTO> salvar(DividaDTO obj) {
        Divida reg = this.dividaRepository.save(DividaDTO.toEntity(obj));
        return ResponseEntity.ok().body(DividaDTO.toDTO(reg));
    }

    public ResponseEntity<DividaDTO> alterar(DividaDTO obj, Long id) {
        return this.dividaRepository.findById(id)
                .map(reg -> {
                    obj.setId(reg.getId());
                    reg = DividaDTO.toEntity(obj);
                    Divida entidade = this.dividaRepository.save(reg);
                    return ResponseEntity.ok().body(DividaDTO.toDTO(entidade));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<DividaDTO> buscarPorId(Long id) {
        return this.dividaRepository.findById(id)
                .map(reg -> ResponseEntity.ok().body(DividaDTO.toDTO(reg)))
                .orElse(ResponseEntity.notFound().build());
    }


    public Page<DividaDTO> pesquisar(Pageable pageable) {
        return this.dividaRepository.findAll(pageable).map(divida -> {
            return DividaDTO.toDTO(divida);
        });
    }

    public ResponseEntity<?> excluir(Long id) {
        return this.dividaRepository.findById(id)
                .map(record -> {
                    this.dividaRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());

    }
}
