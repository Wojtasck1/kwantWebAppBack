import { Component } from '@angular/core';
import { Http } from '@angular/http';

import { trigger, state, style, transition, animate } from '@angular/animations';
import { AccordionModule } from 'primeng/components/accordion/accordion';
import { MenuItem } from 'primeng/components/common/api';
import { HttpComponent } from './http/http.component';

@Component({
  selector: 'app-root', 
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {  
  myData: Array<any>;

  constructor(private http:Http){
    // this.http.get('https://jsonplaaceholder.typicode.com/photos')
    // .map(response => response.json())
    // .subscribe(res => this.myData = res); 
  }

}