package com.example.Paschoalotto.controller;

import com.example.Paschoalotto.business.IDividaBusiness;
import com.example.Paschoalotto.dtos.DividaDTO;
import com.example.Paschoalotto.model.Divida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/divida")
public class DividaController {

    @Autowired
    private IDividaBusiness _dividaBusiness;

    @PostMapping
    public ResponseEntity<DividaDTO> salvar(@Valid @RequestBody DividaDTO dividaDTO) throws Exception {
        return this._dividaBusiness.salvar(dividaDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DividaDTO> alterar(@Valid @RequestBody DividaDTO dividaDTO, @PathVariable Long id) {
        return this._dividaBusiness.alterar(dividaDTO, id);
    }

    @DeleteMapping(path = {"/{id}"})
    public void excluir(@PathVariable("id") Long id){
        this._dividaBusiness.excluir(id);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DividaDTO> buscarPorId(@PathVariable Long id){
        return this._dividaBusiness.buscarPorId(id);
    }

    @GetMapping(value = "/pesquisar")
    public Page<DividaDTO> pesquisar(Pageable pageable) {
        return this._dividaBusiness.pesquisar(pageable);
    }


}
