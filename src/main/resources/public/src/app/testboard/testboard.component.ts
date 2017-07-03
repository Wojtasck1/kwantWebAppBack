import { Component, OnInit } from '@angular/core';
import { Car } from '../domain/car';
import { HttpCarService } from '../http/http-car.service';

@Component({
  selector: 'app-testboard',
  templateUrl: './testboard.component.html',
  styleUrls: ['./testboard.component.css']
})
export class TestboardComponent implements OnInit {

    // cars1: Car[];
    
    // cars2: Car[];  

    // constructor(private carService: HttpCarService) { }

    ngOnInit() {
    //    this.carService.getCarsSmall().then(cars => this.cars2 = cars);
    }

}
 