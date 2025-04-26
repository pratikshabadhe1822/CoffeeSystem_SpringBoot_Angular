import { TestBed } from '@angular/core/testing';

import { CoffeeItemService } from './coffee.service';

describe('CoffeeService', () => {
  let service: CoffeeItemService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CoffeeItemService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
