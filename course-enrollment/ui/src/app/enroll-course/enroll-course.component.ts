import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-enroll-course',
  standalone: true,
  imports: [CommonModule, FormsModule],
  template: `
    <h2>Enroll in a Course</h2>
    <form (ngSubmit)="enroll()">
      <label>Student Name:</label>
      <input [(ngModel)]="studentName" name="studentName" required>
      <br><br>

      <label>Course:</label>
      <select [(ngModel)]="selectedCourse" name="course" required>
        <option *ngFor="let course of courses" [value]="course">{{ course }}</option>
      </select>
      <br><br>

      <button type="submit">Enroll</button>
    </form>

    <p *ngIf="message">{{ message }}</p>
  `
})
export class EnrollCourseComponent {
  courses = ['Java Basics', 'Spring Boot', 'Angular Fundamentals', 'Microservices'];
  studentName = '';
  selectedCourse = '';
  message = '';

  enroll() {
    if (this.studentName && this.selectedCourse) {
      this.message = `${this.studentName} enrolled in ${this.selectedCourse}! 🎉`;
    }
  }
}
