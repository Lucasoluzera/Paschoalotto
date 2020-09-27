import {TipoJuros} from "../enums/tipo-juros";

export class DividaDTO {
    id: number;
    valorDivida: number;
    tipoJuros: TipoJuros;
    qtdeParcelas: number;
    porcentagemComissao: number;
    diaVencimento: number;

}