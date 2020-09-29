import {Injectable} from '@angular/core';
import {MatSnackBar} from "@angular/material/snack-bar";
import {HttpClient, HttpErrorResponse, HttpHeaders} from "@angular/common/http";
import {DividaDTO} from "../../model/dividaDTO";
import {Observable, throwError} from "rxjs";
import {catchError} from "rxjs/operators";

@Injectable({
    providedIn: 'root'
})
export class DividaService {

    baseUrl = "http://localhost:8080/divida"

    headers: HttpHeaders = new HttpHeaders();


    constructor(private snackBar: MatSnackBar, private http: HttpClient) {
        this.headers = this.headers.set('Content-Type', 'application/json;charset=UTF-8');
    }

    showMessage(msg: string): void {
        this.snackBar.open(msg, 'x', {
            duration: 3000,
            horizontalPosition: "right",
            verticalPosition: "top"
        })
    }

    salvar(divida: DividaDTO): Observable<DividaDTO> {
        if (!divida.id) {
            return this.http.post<DividaDTO>(this.baseUrl, JSON.stringify(divida), {headers: this.headers})
                .pipe(
                    catchError(this.obterErro)
                );
        } else {
            return this.http.put<DividaDTO>(`${this.baseUrl}/${divida.id}`, JSON.stringify(divida), {headers: this.headers})
                .pipe(
                    catchError(this.obterErro)
                );
        }
    }

    listar(): Observable<any> {
        return this.http.get<any>(this.baseUrl + `/pesquisar`)
            .pipe(
                catchError(this.obterErro)
            );
    }


    consultarPorId(id: number): Observable<DividaDTO> {
        return this.http.get<DividaDTO>(`${this.baseUrl}/${id}`)
            .pipe(
                catchError(this.obterErro)
            );
    }


    excluir(id: number): Observable<any> {
        return this.http.delete(`${this.baseUrl}/${id}`)
            .pipe(
                catchError(this.obterErro)
            );
    }

    obterErro(erro: HttpErrorResponse) {
        if (erro.error instanceof ErrorEvent) {
            console.log('Ocorreu um erro: ', erro.error.message);
        } else {
            console.log(`Backend retornou o codigo ${erro.status}`);
            try {
                if (erro.error.length > 0) {
                    const mensagemUsuario = erro.error[0].message;
                    const mensagemDesenvolvedor = erro.error[0].exception;
                    console.log(mensagemDesenvolvedor);
                    return throwError(mensagemUsuario);
                }
            } catch (error) {
                // HttpStatus.NOT_FOUND
                return throwError('Registro não encontrado. Por favor, verifique.');
            }
        }
        return throwError('');
    }
}
