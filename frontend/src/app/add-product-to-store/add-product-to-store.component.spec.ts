import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddProductToStoreComponent } from './add-product-to-store.component';

describe('AddProductToStoreComponent', () => {
  let component: AddProductToStoreComponent;
  let fixture: ComponentFixture<AddProductToStoreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddProductToStoreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddProductToStoreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
