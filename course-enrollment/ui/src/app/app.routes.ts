import { Routes } from '@angular/router';
import { CourseListComponent } from './course-list/course-list.component';
import { EnrollCourseComponent } from './enroll-course/enroll-course.component';

export const routes: Routes = [
  { path: '', redirectTo: 'courses', pathMatch: 'full' },
  { path: 'courses', component: CourseListComponent },
  { path: 'enroll', component: EnrollCourseComponent }
];