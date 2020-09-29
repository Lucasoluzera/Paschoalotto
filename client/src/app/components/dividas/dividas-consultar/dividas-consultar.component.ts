import { Component, OnInit } from '@angular/core';
import {DividaDTO} from "../../../model/dividaDTO";
import {DividaService} from "../divida.service";

@Component({
  selector: 'app-divida-consultar',
  templateUrl: './dividas-consultar.component.html',
  styleUrls: ['./dividas-consultar.component.css']
})
export class DividasConsultarComponent implements OnInit {

  dividas: DividaDTO[]
  displayedColumns = ['action', 'id', 'valorDivida', 'tipoJuros', 'qtdeParcelas', 'porcentagemComissao', 'valorComissao', 'diaVencimento', 'telefone']

  constructor(private dividaService: DividaService) { }

  ngOnInit(): void {
    this.dividaService.listar().subscribe(ret => {
      console.log(ret.content);
      this.dividas = ret.content;
    })
  }

}
