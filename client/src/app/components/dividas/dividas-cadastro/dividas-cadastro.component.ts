import {Component, OnInit} from '@angular/core';
import {DividaService} from "../divida.service";
import {Router} from "@angular/router";
import {DividaDTO} from "../../../model/dividaDTO";
import {FormGroup} from "@angular/forms";
import {TipoJuros} from "../../../enums/tipo-juros";

@Component({
    selector: 'app-divida-cadastro',
    templateUrl: './dividas-cadastro.component.html',
    styleUrls: ['./dividas-cadastro.component.css']
})
export class DividasCadastroComponent implements OnInit {

    divida: DividaDTO = new DividaDTO();
    tipoJuros = TipoJuros;
    formulario: FormGroup;


    constructor(
        private dividaService: DividaService,
        private router: Router
    ) {
    }

    ngOnInit(): void {
        this.formulario = DividaDTO.montarFormulario(new DividaDTO());
    }

    cadastrarDivida(): void {
        this.divida = this.formulario.getRawValue()

        console.log(this.formulario.getRawValue())

        if(this.formulario.invalid)
            return this.dividaService.showMessage(`Por favor verifique as informações!`);

        this.dividaService.salvar(this.divida).subscribe(() => {
            this.dividaService.showMessage('Nova dívida cadastrada com sucesso!')
            this.router.navigate(['/divida'])
        })
    }

    cancelar(): void {
        this.router.navigate(['/divida'])
    }
}
