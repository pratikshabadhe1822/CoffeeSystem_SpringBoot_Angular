import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CoffeeItem } from '../models/coffee';

@Injectable({
  providedIn: 'root'
})
export class CoffeeItemService {
  private baseUrl = 'http://localhost:8090/coffeeitems'; // Make sure backend is running!

  constructor(private http: HttpClient) {}

  getAll(): Observable<CoffeeItem[]> {
    return this.http.get<CoffeeItem[]>(`${this.baseUrl}/all`);
  }

  getById(id: number): Observable<CoffeeItem> {
    return this.http.get<CoffeeItem>(`${this.baseUrl}/${id}`);
  }

  add(coffeeItem: CoffeeItem): Observable<CoffeeItem> {
    return this.http.post<CoffeeItem>(`${this.baseUrl}/register`, coffeeItem);
  }

  update(id: number, coffeeItem: CoffeeItem): Observable<CoffeeItem> {
    return this.http.put<CoffeeItem>(`${this.baseUrl}/update/${id}`, coffeeItem);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/delete/${id}`);
  }
}
