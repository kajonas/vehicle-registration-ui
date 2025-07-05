import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Make } from '../models/make.model';
import { Model } from '../models/model.model';
import { Vehicle } from '../models/vehicle.model';

@Injectable({ providedIn: 'root' })
export class VehicleService {
  private baseUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  getMakes(): Observable<Make[]> {
    return this.http.get<Make[]>(`${this.baseUrl}/makes`);
  }

  getModels(makeId: number): Observable<Model[]> {
    return this.http.get<Model[]>(`${this.baseUrl}/models/${makeId}`);
  }

  getVehicles(): Observable<Vehicle[]> {
    return this.http.get<Vehicle[]>(`${this.baseUrl}/vehicles`);
  }

  saveVehicle(vehicle: Vehicle): Observable<Vehicle> {
    return this.http.post<Vehicle>(`${this.baseUrl}/vehicles`, vehicle);
  }
}
