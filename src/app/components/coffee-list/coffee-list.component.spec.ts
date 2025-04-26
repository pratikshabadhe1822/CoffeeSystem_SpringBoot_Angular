import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoffeeItemListComponent } from './coffee-list.component';

describe('CoffeeListComponent', () => {
  let component: CoffeeItemListComponent;
  let fixture: ComponentFixture<CoffeeItemListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CoffeeItemListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CoffeeItemListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
