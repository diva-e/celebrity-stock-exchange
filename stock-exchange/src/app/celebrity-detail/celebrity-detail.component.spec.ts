import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CelebrityDetailComponent } from './celebrity-detail.component';

describe('CelebrityDetailComponent', () => {
  let component: CelebrityDetailComponent;
  let fixture: ComponentFixture<CelebrityDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CelebrityDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CelebrityDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
