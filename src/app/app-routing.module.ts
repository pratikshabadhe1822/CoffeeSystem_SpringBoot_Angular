import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CoffeeItemListComponent } from './components/coffee-list/coffee-list.component';
import { CoffeeItemFormComponent } from './components/coffee-form/coffee-form.component';
import { CoffeeItemDetailComponent } from './components/coffee-detail/coffee-detail.component';

const routes: Routes = [
  { path: '', redirectTo: 'coffeeitems', pathMatch: 'full' },
  { path: 'coffeeitems', component: CoffeeItemListComponent },
  { path: 'coffeeitems/add', component: CoffeeItemFormComponent },
  { path: 'coffeeitems/edit/:id', component: CoffeeItemFormComponent },
  { path: 'coffeeitems/:id', component: CoffeeItemDetailComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
