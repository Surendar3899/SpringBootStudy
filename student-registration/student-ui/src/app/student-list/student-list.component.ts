import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StudentService, Student } from '../student.service';

@Component({
  selector: 'app-student-list',
  standalone: true,
  imports: [CommonModule],
  template: `
    <h2>Student List</h2>
    <ul>
      <li *ngFor="let s of students">
        {{ s.name }} - {{ s.email }} - {{ s.course }}
        <button (click)="deleteStudent(s.id!)">Delete</button>
      </li>
    </ul>
  `
})
export class StudentListComponent implements OnInit {
  students: Student[] = [];

  constructor(private service: StudentService) {}

  ngOnInit() {
    this.loadStudents();
  }

  loadStudents() {
    this.service.getAll().subscribe(data => this.students = data);
  }

  deleteStudent(id: number) {
    this.service.delete(id).subscribe(() => this.loadStudents());
  }
}
