import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import {RouterModule, Routes} from '@angular/router';

import {HotelService} from './servics/hotel.service';

import { ListHotelComponent } from './components/list-hotel/list-hotel.component';
import { AddHotelComponent } from './components/add-hotel/add-hotel.component';

const appRoutes : Routes=[
  {path:'', component:ListHotelComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    ListHotelComponent,
    AddHotelComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [HotelService],
  bootstrap: [AppComponent]
})
export class AppModule { }
