import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CollboratorComponent } from './collborator.component';

describe('CollboratorComponent', () => {
  let component: CollboratorComponent;
  let fixture: ComponentFixture<CollboratorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CollboratorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CollboratorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
