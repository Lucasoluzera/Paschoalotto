import {TipoJuros} from "../enums/tipo-juros";
import {FormControl, FormGroup, Validators} from "@angular/forms";

export class DividaDTO {
    id: number;
    valorDivida: number;
    tipoJuros: TipoJuros;
    qtdeParcelas: number;
    porcentagemComissao: number;
    porcentagemJuros: number;
    diaVencimento: Date;
    datasVencimento: Date[];
    valorComissao: number;
    parcelas: number[];
    telefone: number;

    static montarFormulario(dividaDTO: DividaDTO): FormGroup {
        return new FormGroup({
            id: new FormControl({value: dividaDTO.id, disabled: true}),
            valorDivida: new FormControl(dividaDTO.valorDivida, [Validators.required, Validators.minLength(0)]),
            tipoJuros: new FormControl(dividaDTO.tipoJuros, [Validators.required]),
            qtdeParcelas: new FormControl(dividaDTO.qtdeParcelas, [Validators.required, Validators.minLength(0), Validators.maxLength(100)]),
            porcentagemComissao: new FormControl(dividaDTO.porcentagemComissao, [Validators.required]),
            porcentagemJuros: new FormControl(dividaDTO.porcentagemJuros, [Validators.required]),
            diaVencimento: new FormControl(dividaDTO.diaVencimento, [Validators.required]),
            telefone: new FormControl(dividaDTO.telefone),
            datasVencimento: new FormControl(dividaDTO.datasVencimento),
            parcelas: new FormControl(dividaDTO.parcelas, [Validators.minLength(0)]),
            valorComissao: new FormControl(dividaDTO.valorComissao),
        })
    }
}
