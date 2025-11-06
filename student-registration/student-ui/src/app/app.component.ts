import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StudentAddComponent } from './student-add/student-add.component';
import { StudentListComponent } from './student-list/student-list.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, StudentAddComponent, StudentListComponent],
  template: `
    <h1>🎓 Student Registration</h1>
    <app-student-add></app-student-add>
    <hr />
    <app-student-list></app-student-list>
  `
})
export class AppComponent {}
