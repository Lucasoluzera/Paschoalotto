package com.example.Paschoalotto.controller;

import com.example.Paschoalotto.business.IDividaBusiness;
import com.example.Paschoalotto.model.Divida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/templateDocumentoGed")
public class DividaController {

    @Autowired
    private IDividaBusiness _dividaBusiness;


    @PostMapping
    public ResponseEntity<Divida> salvar(@Valid @RequestBody Divida divida) throws Exception {
        return this._dividaBusiness.salvar(divida);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Divida> alterar(@Valid @RequestBody Divida divida, @PathVariable Long id) {
        return this._dividaBusiness.alterar(divida, id);
    }

    @DeleteMapping(path = {"/{id}"})
    public void excluir(@PathVariable("id") Long id){
        this._dividaBusiness.excluir(id);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Divida> buscarPorId(@PathVariable Long id){
        return this._dividaBusiness.buscarPorId(id);
    }

    @GetMapping(value = "/pesquisar")
    public Page<Divida> pesquisar(Pageable pageable) {
        return this._dividaBusiness.pesquisar(pageable);
    }


}
