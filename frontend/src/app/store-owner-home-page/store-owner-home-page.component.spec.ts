import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StoreOwnerHomePageComponent } from './store-owner-home-page.component';

describe('StoreOwnerHomePageComponent', () => {
  let component: StoreOwnerHomePageComponent;
  let fixture: ComponentFixture<StoreOwnerHomePageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StoreOwnerHomePageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StoreOwnerHomePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
