import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Motorcycle } from './motorcycle';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class MotorcycleService {
  private apiServerUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  public getMotorcycles(): Observable<Motorcycle[]>{
    return this.http.get<Motorcycle[]>(`${this.apiServerUrl}/motorcycle/all`);
  }
  public addMotorcycle(motorcycle: Motorcycle): Observable<Motorcycle>{
    return this.http.post<Motorcycle>(`${this.apiServerUrl}/motorcycle/add`, motorcycle);
  }
  public updateMotorcycle(motorcycle: Motorcycle): Observable<Motorcycle>{
    return this.http.put<Motorcycle>(`${this.apiServerUrl}/motorcycle/update`, motorcycle);
  }
  public deleteMotorcycle(motorcycleId: number): Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/motorcycle/delete/${motorcycleId}`);
  }
}
