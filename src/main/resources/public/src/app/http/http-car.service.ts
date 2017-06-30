import { Injectable } from '@angular/core';
import {Http} from '@angular/http';
import {Observable}     from 'rxjs/Observable';
import 'rxjs/Rx';

@Injectable()
export class HttpCarService {

constructor(private http: Http) { }

  fetchCars(){
    return this.http.get('http://localhost:8080/api/v1/car').map(
      (res) => res.json()
    ).subscribe( 
      (data) => console.warn(data.responseText) 
    );
  } 
  DeleteCar(){
    return this.http.delete('http://localhost:8080/api/v1/car').map(
      (res) => res.json()
    ).subscribe( 
      (data) => console.warn(data.responseText) 
    );
  } 
  //   CreateCar(){
  //   return this.http.post('http://localhost:8080/api/v1/car').map(
  //     (res) => res.json()
  //   ).subscribe( 
  //     (data) => console.warn(data.responseText) 
  //   );
  // } 
} 