import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [CommonModule],
  template: `
    <h2>Available Courses</h2>
    <ul>
      <li *ngFor="let course of courses">{{ course }}</li>
    </ul>
  `
})
export class CourseListComponent {
  courses = ['Java Basics', 'Spring Boot', 'Angular Fundamentals', 'Microservices'];
}
