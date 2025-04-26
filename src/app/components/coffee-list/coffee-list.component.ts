import { Component, OnInit } from '@angular/core';
import { CoffeeItemService } from '../../services/coffee.service';
import { CoffeeItem } from '../../models/coffee';
import { Router, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-coffee-item-list',
  standalone: true,
  templateUrl: './coffee-list.component.html',
  styleUrls: ['./coffee-list.component.css'],
  imports: [CommonModule, RouterModule],
})
export class CoffeeItemListComponent implements OnInit {

  coffeeItems: CoffeeItem[] = [];

  constructor(private service: CoffeeItemService, private router: Router) {}

  ngOnInit(): void {
    this.loadCoffeeItems();
  }

  loadCoffeeItems(): void {
    this.service.getAll().subscribe({
      next: (data) => {
        this.coffeeItems = data;
      },
      error: (err) => {
        console.error('Error loading coffee items', err);
      }
    });
  }

  deleteCoffeeItem(id: number): void {
    if (confirm('Are you sure you want to delete this coffee item?')) {
      this.service.delete(id).subscribe({
        next: () => {
          this.loadCoffeeItems();
        },
        error: (err) => {
          console.error('Error deleting coffee item', err);
        }
      });
    }
  }

}
