import { Component, OnInit } from '@angular/core';
import { CourseService } from '../course.service';

@Component({
  selector: 'app-enrolled-students',
  templateUrl: './enrolled-students.component.html',
  styleUrls: ['./enrolled-students.component.css']
})
export class EnrolledStudentsComponent implements OnInit {
  enrolled: any[] = [];

  constructor(private courseService: CourseService) {}

  ngOnInit() {
    this.courseService.getEnrolledStudents().subscribe(data => {
      this.enrolled = data;
    });
  }
}
