import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CoffeeItemService } from '../../services/coffee.service';
import { CoffeeItem } from '../../models/coffee';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-coffee-item-detail',
  standalone: true,
  templateUrl: './coffee-detail.component.html',
  imports: [CommonModule],
})
export class CoffeeItemDetailComponent implements OnInit {
  coffeeItem?: CoffeeItem;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private coffeeItemService: CoffeeItemService
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.coffeeItemService.getById(+id).subscribe({
        next: (data) => this.coffeeItem = data,
        error: () => this.router.navigate(['/coffeeitems'])
      });
    }
  }
}
