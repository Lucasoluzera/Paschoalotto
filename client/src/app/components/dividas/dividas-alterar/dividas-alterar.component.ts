import {Component, OnInit} from '@angular/core';
import {DividaService} from "../divida.service";
import {ActivatedRoute, Router} from "@angular/router";
import {DividaDTO} from "../../../model/divida-dto";

@Component({
    selector: 'app-ingressos-alterar',
    templateUrl: './dividas-alterar.component.html',
    styleUrls: ['./dividas-alterar.component.css']
})
export class DividasAlterarComponent implements OnInit {

    divida: DividaDTO

    constructor(private dividaService: DividaService,
                private router: Router,
                private route: ActivatedRoute
    ) {
    }

    ngOnInit(): void {
        const id = this.divida.id;
        this.dividaService.consultarPorId(id).subscribe(ingresso => {
            this.divida = ingresso
        });
    }

    alterarIngresso(): void {
        this.dividaService.salvar(this.divida).subscribe(() => {
            this.dividaService.showMessage('Divida Alterada com sucesso!')
            this.router.navigate(['/dividas'])
        })
    }

    cancelar(): void {
        this.router.navigate(['/dividas'])
    }

    excluir(): void{
        this.dividaService.excluir(this.divida.id).subscribe( () =>
        {
            this.dividaService.showMessage('Divida excluida com sucesso')
            this.router.navigate(['/dividas'])
        })
    }


}
