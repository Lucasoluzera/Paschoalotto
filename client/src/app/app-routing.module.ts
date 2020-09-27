import {RouterModule, Routes} from "@angular/router";
import {HomeComponent} from "./views/home/home.component";
import {DividasCrudComponent} from "./views/ingressos-crud/dividas-crud.component";
import {DividasCadastroComponent} from "./components/dividas/dividas-cadastro/dividas-cadastro.component";
import {DividasAlterarComponent} from "./components/dividas/dividas-alterar/dividas-alterar.component";
import {NgModule} from "@angular/core";


const routes: Routes = [
    {
        path: "",
        component: HomeComponent
    },
    {
        path: 'dividas',
        component: DividasCrudComponent
    },
    {
        path: 'novo',
        component: DividasCadastroComponent
    },
    {
        path: ':id/editar',
        component: DividasAlterarComponent
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
