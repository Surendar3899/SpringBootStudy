import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { StudentService, Student } from '../student.service';

@Component({
  selector: 'app-student-add',
  standalone: true,
  imports: [CommonModule, FormsModule],
  template: `
    <h2>Add Student</h2>
    <form (ngSubmit)="addStudent()" class="form">
      <input [(ngModel)]="student.name" name="name" placeholder="Name" required />
      <input [(ngModel)]="student.email" name="email" placeholder="Email" required />
      <input [(ngModel)]="student.course" name="course" placeholder="Course" required />
      <button type="submit">Add</button>
    </form>
  `,
  styles: [`
    .form {
      display: flex;
      flex-direction: column;
      gap: 10px;
      width: 300px;
    }
  `]
})
export class StudentAddComponent {
  student: Student = { name: '', email: '', course: '' };

  constructor(private service: StudentService) {}

  addStudent() {
    this.service.create(this.student).subscribe(() => {
      alert('✅ Student added successfully!');
      this.student = { name: '', email: '', course: '' };
    });
  }
}
