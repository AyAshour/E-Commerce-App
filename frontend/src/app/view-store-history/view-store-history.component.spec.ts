import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewStoreHistoryComponent } from './view-store-history.component';

describe('ViewStoreHistoryComponent', () => {
  let component: ViewStoreHistoryComponent;
  let fixture: ComponentFixture<ViewStoreHistoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewStoreHistoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewStoreHistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
