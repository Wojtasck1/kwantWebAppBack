import { Component, OnInit } from '@angular/core';
import { trigger, state, style, transition, animate } from '@angular/animations';
import { Ng2SmartTableModule , LocalDataSource } from 'ng2-smart-table';
import { HttpCarService } from '../http/http-car.service';
import { Car } from '../domain/car';

@Component({
  selector: 'app-mainboard',
  templateUrl: './mainboard.component.html',
  styleUrls: ['./mainboard.component.css'],
  providers: [HttpCarService] 
})

export class MainboardComponent implements OnInit {

settings = { 
    delete: { 
      confirmDelete: true,
    }, 
    add: {
      confirmCreate: true,
    }, 
    edit: { 
      confirmSave: true,
    },
    columns: {
      plates: {
        title: 'Tablica Rej',
        filter: true
      },
      custommer: {
        title: 'Użytkownik',
        filter: true
      },
      course: {
        title: 'Bieżący przebieg',
        filter: true
      },
      insurance: {
        title: 'Termin oc',
        filter: true
      },
      overview: {
        title: 'Termin przeglądu',
        filter: true
      },
    }, 
  }; 

  //source: Car[];

//source: LocalDataSource;  
 
cars: Car[];
errorString: string;  

public getCars(){
  this._httpCarService.getCars().subscribe(
    cars => this.cars = cars,
    error => this.errorString = <any> error
  );
}

  source: LocalDataSource;

  constructor( protected _httpCarService : HttpCarService) { 
    this.getCars();
    console.log(this.cars); 

    
    // this.source = new LocalDataSource();

    //     this._httpCarService.getCars();
     //  console.log(this._httpCarService.getCars()); 
         
      //   .then((data) => {
      // this.sour      e.load(data);
   // }
    // ); 
  }

  ngOnInit() {
    // this.source = new LocalDataSource(this.data); 
    // console.log(this.data);
  }
  
  onDeleteConfirm(event) {
    if (window.confirm('Are you sure you want to delete?')) {
      event.confirm.resolve();
    } else {
      event.confirm.reject();
    }
  } 

  onSaveConfirm(event) {
    if (window.confirm('Are you sure you want to save?')) {
      event.newData['name'] += ' + added in code';
      event.confirm.resolve(event.newData);
    } else {
      event.confirm.reject();
    }
  }

  onCreateConfirm(event) {
    if (window.confirm('Are you sure you want to create?')) {
      event.newData['name'] += ' + added in code';
      event.confirm.resolve(event.newData);
    } else {
      event.confirm.reject();
    }
  }
}
