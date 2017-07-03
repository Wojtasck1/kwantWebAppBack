import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MdButtonModule, MdCardModule, MdMenuModule, MdToolbarModule, MdIconModule } from '@angular/material';

import { MaterialModule } from '@angular/material';
import { Ng2SmartTableModule } from 'ng2-smart-table';
import { HttpComponent } from './http/http.component';
import { MainboardComponent } from './mainboard/mainboard.component';

import { AppComponent } from './app.component';
import 'hammerjs';
import { TestboardComponent } from './testboard/testboard.component';


@NgModule({
  declarations: [
    AppComponent,
    MainboardComponent,
    HttpComponent,
    TestboardComponent
  ],
  imports: [ 
    BrowserModule,
    FormsModule,
    HttpModule, 
    Ng2SmartTableModule,
    BrowserAnimationsModule,
    MaterialModule,
    MdButtonModule, 
    MdCardModule, 
    MdMenuModule, 
    MdToolbarModule, 
    MdIconModule
  ],
  providers: [],
  bootstrap: [AppComponent] 
})
export class AppModule { } 
