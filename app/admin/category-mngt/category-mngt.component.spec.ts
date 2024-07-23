import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CategoryMngtComponent } from './category-mngt.component';

describe('CategoryMngtComponent', () => {
  let component: CategoryMngtComponent;
  let fixture: ComponentFixture<CategoryMngtComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CategoryMngtComponent]
    });
    fixture = TestBed.createComponent(CategoryMngtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
