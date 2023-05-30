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

  public onOpenModal(motorcycle: Motorcycle | null, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button. style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode == 'add'){
      button.setAttribute('data-target', '#addMotorcycleModal')
    }
    if (mode == 'edit'){
      button.setAttribute('data-target', '#editMotorcycleModal')
    }
    if (mode == 'delete'){
      button.setAttribute('data-target', '#deleteMotorcycleModal')
    }  
    if (container !== null) {
      container.appendChild(button);
    }
    button.click();
  }
  

}
