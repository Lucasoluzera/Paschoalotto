import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-divida-crud',
  templateUrl: './dividas-crud.component.html',
  styleUrls: ['./dividas-crud.component.css']
})
export class DividasCrudComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
    console.log(`teste`);
  }

  navigateToProductCreate() : void{
    this.router.navigate(['divida/novo'])
    console.log('create')
  }

}
