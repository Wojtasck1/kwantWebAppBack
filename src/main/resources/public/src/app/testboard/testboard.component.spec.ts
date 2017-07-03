import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TestboardComponent } from './testboard.component';

describe('TestboardComponent', () => {
  let component: TestboardComponent;
  let fixture: ComponentFixture<TestboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TestboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TestboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
