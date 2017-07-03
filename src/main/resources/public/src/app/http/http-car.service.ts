import { Injectable } from '@angular/core';
import {Http , Response} from '@angular/http';
import {Observable}     from 'rxjs/Observable';
import { Car } from '../domain/car'
import 'rxjs/add/operator/map';
import 'rxjs/Rx';

@Injectable()
export class HttpCarService {

constructor(private http: Http) { }

 
    getCarsSmall() {
        return this.http.get('http://localhost:8080/api/v1/car').map(
          (res) => res.json() 
        ).subscribe(
          (data) => console.warn(data.responseText)
        )
                    // .toPromise() 
                    // .then(res => <Car[]> res.json().data)
                    // .then(data => { return data; });
    }
      getCars(): Observable<Car[]> {  
    return this.http.get('http://localhost:8080/api/v1/car') 
                    .map(res => <Car[]> res.json())
                    .catch(this.handleError);
  } 

  fetchCars(){
    return this.http.get('http://localhost:8080/api/v1/car').map(
      (res) => res.json()
    ).subscribe( 
      (data) => console.log(data.responseText) 
    );
  } 
  DeleteCar(){
    return this.http.delete('http://localhost:8080/api/v1/car').map(
      (res) => res.json()
    ).subscribe(
      (data) => console.warn(data.responseText) 
    );
  } 

      private handleError (error: Response | any) {
    // In a real world app, you might use a remote logging infrastructure
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body); 
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else { 
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }
  //   CreateCar(){
  //   return this.http.post('http://localhost:8080/api/v1/car').map(
  //     (res) => res.json()
  //   ).subscribe( 
  //     (data) => console.warn(data.responseText) 
  //   );
  // } 
} 