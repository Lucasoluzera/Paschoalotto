import { Component, OnInit } from '@angular/core';
import {DividaService} from "../divida.service";
import {Router} from "@angular/router";
import {DividaDTO} from "../../../model/divida-dto";

@Component({
  selector: 'app-ingressos-cadastro',
  templateUrl: './dividas-cadastro.component.html',
  styleUrls: ['./dividas-cadastro.component.css']
})
export class DividasCadastroComponent implements OnInit {

  divida: DividaDTO = new DividaDTO();

  constructor(
      private ingressosService: DividaService,
      private router: Router
  ) { }

  ngOnInit(): void {
  }

  cadastrarIngresso(): void{
    this.ingressosService.salvar(this.divida).subscribe( () =>{
      this.ingressosService.showMessage('Rolê cadastrado com sucesso!')
      this.router.navigate(['/dividas'])
    })

  }

  cancelar(): void{
    this.router.navigate(['/dividas'])
  }
}
