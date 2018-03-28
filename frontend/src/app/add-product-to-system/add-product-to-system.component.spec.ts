import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddProductToSystemComponent } from './add-product-to-system.component';

describe('AddProductToSystemComponent', () => {
  let component: AddProductToSystemComponent;
  let fixture: ComponentFixture<AddProductToSystemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddProductToSystemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddProductToSystemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
