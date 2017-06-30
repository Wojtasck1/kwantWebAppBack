import { Component, OnInit } from '@angular/core';
import { trigger, state, style, transition, animate } from '@angular/animations';
import { Ng2SmartTableModule , LocalDataSource } from 'ng2-smart-table';
import { HttpCarService } from '../http/http-car.service';

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
      state: {
        title: 'Tablica Rej',
        filter: true
      },
      custommer: {
        title: 'Użytkownik',
        filter: true
      },
      contact: {
        title: 'Bieżący przebieg',
        filter: true
      },
      location: {
        title: 'Termin oc',
        filter: true
      },
      description: {
        title: 'Termin przeglądu',
        filter: true
      },
    }, 
  }; 

  constructor( private _httpCarService : HttpCarService) { 

  } 

  ngOnInit() {
    this._httpCarService.fetchCars;
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
