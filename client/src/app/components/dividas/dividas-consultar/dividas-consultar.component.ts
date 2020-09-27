import { Component, OnInit } from '@angular/core';
import {DividaDTO} from "../../../model/divida-dto";
import {DividaService} from "../divida.service";

@Component({
  selector: 'app-ingressos-consultar',
  templateUrl: './dividas-consultar.component.html',
  styleUrls: ['./dividas-consultar.component.css']
})
export class DividasConsultarComponent implements OnInit {

  dividas: DividaDTO[]
  displayedColumns = ['id', 'name', 'price', 'action']

  constructor(private dividaService: DividaService) { }

  ngOnInit(): void {
    this.dividaService.listar().subscribe(ret => {
      this.dividas = ret
      console.log(ret)
    })
  }

}
