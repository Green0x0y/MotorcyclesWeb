import { Component, OnInit } from '@angular/core';
import { Motorcycle } from './motorcycle';
import { MotorcycleService } from './motorcycle.service';
import { HttpErrorResponse } from '@angular/common/http';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  public motorcycles!: Motorcycle[];

  constructor( private motorcycleService: MotorcycleService){}

  ngOnInit(): void {
    this.getMotorcycles();
  }

  public getMotorcycles(): void{
    this.motorcycleService.getMotorcycles().subscribe(
      (response: Motorcycle[]) => {
        this.motorcycles = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }
}
