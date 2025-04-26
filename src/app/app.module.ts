import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { CoffeeItemListComponent } from './components/coffee-list/coffee-list.component';
import { CoffeeItemFormComponent } from './components/coffee-form/coffee-form.component';
import { CoffeeItemDetailComponent } from './components/coffee-detail/coffee-detail.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    CoffeeItemListComponent,
    CoffeeItemFormComponent,
    CoffeeItemDetailComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
