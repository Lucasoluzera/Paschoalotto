import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-ingressos-crud',
  templateUrl: './dividas-crud.component.html',
  styleUrls: ['./dividas-crud.component.css']
})
export class DividasCrudComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  navigateToProductCreate() : void{
    this.router.navigate(['/dividas/cadastro'])
    console.log('create')
  }

}
