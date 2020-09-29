import {Component, OnInit} from '@angular/core';
import {DividaService} from "../divida.service";
import {ActivatedRoute, Router} from "@angular/router";
import {DividaDTO} from "../../../model/dividaDTO";
import {TipoJuros} from "../../../enums/tipo-juros";
import {FormGroup} from "@angular/forms";

@Component({
    selector: 'app-divida-alterar',
    templateUrl: './dividas-alterar.component.html',
    styleUrls: ['./dividas-alterar.component.css']
})
export class DividasAlterarComponent implements OnInit {

    divida: DividaDTO;
    tipoJuros = TipoJuros;
    formulario: FormGroup;

    constructor(
        private dividaService: DividaService,
        private router: Router,
        protected aRoute: ActivatedRoute,
    ) {
    }

    ngOnInit(): void {
        this.aRoute.params.subscribe(par => {
            const id = par['id'];
            if (id)
                this.dividaService.consultarPorId(id).subscribe(ret => {
                    this.divida = ret
                    this.formulario = DividaDTO.montarFormulario(ret);
                });
        });
    }

    alterarDivida(): void {
        this.divida = this.formulario.getRawValue()

        if (this.formulario.invalid)
            return this.dividaService.showMessage(`Por favor verifique as informações!`);


        this.dividaService.salvar(this.divida).subscribe(() => {
            this.dividaService.showMessage('Divida Alterada com sucesso!')
            this.router.navigate(['/divida'])
        })
    }

    cancelar(): void {
        this.router.navigate(['/divida'])
    }

    excluir(): void {
        this.dividaService.excluir(this.divida.id).subscribe(() => {
            this.dividaService.showMessage('Divida excluida com sucesso')
            this.router.navigate(['/divida'])
        })
    }


}
