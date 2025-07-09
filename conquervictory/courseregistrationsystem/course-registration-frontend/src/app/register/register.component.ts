import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CourseService } from '../course.service';

@Component({
  selector: 'app-register',
  standalone: true, // ✅ This line is required
  imports: [FormsModule], // ✅ This is now valid
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  name = '';
  emailId = '';
  courseName = '';
  message = '';

  constructor(private courseService: CourseService) {}

  register() {
    this.courseService.registerCourse(this.name, this.emailId, this.courseName)
      .subscribe(response => {
        this.message = response;
      });
  }
}
