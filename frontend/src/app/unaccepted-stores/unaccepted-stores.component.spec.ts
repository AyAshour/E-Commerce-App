import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UnacceptedStoresComponent } from './unaccepted-stores.component';

describe('UnacceptedStoresComponent', () => {
  let component: UnacceptedStoresComponent;
  let fixture: ComponentFixture<UnacceptedStoresComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UnacceptedStoresComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UnacceptedStoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
