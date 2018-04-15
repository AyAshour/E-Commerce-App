import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StoreOwnerPageComponent } from './store-owner-page.component';

describe('StoreOwnerPageComponent', () => {
  let component: StoreOwnerPageComponent;
  let fixture: ComponentFixture<StoreOwnerPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StoreOwnerPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StoreOwnerPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
