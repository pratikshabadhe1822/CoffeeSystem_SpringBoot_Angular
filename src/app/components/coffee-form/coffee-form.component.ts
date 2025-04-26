import { Component, OnInit } from '@angular/core';
import { CoffeeItemService } from '../../services/coffee.service';
import { CoffeeItem } from '../../models/coffee';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-coffee-item-form',
  standalone: true,
  templateUrl: './coffee-form.component.html',
  imports: [FormsModule, CommonModule],
})
export class CoffeeItemFormComponent implements OnInit {
  coffeeItem: CoffeeItem = {
    coffeeId: 0,
    coffeeName: '',
    price: 0
  };
  isEditMode = false;

  constructor(
    private service: CoffeeItemService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.isEditMode = true;
      this.service.getById(+id).subscribe(item => this.coffeeItem = item);
    }
  }

  onSubmit() {
    if (this.isEditMode) {
      this.service.update(this.coffeeItem.coffeeId!, this.coffeeItem).subscribe(() => this.router.navigate(['/coffeeitems']));
    } else {
      this.service.add(this.coffeeItem).subscribe(() => this.router.navigate(['/coffeeitems']));
    }
  }
}
