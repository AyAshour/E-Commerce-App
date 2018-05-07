import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewMyStoresComponent } from './view-my-stores.component';

describe('ViewMyStoresComponent', () => {
  let component: ViewMyStoresComponent;
  let fixture: ComponentFixture<ViewMyStoresComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewMyStoresComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewMyStoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
