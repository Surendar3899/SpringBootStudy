import { Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { AvailableCoursesComponent } from './available-courses/available-courses.component';
import { EnrolledStudentsComponent } from './enrolled-students/enrolled-students.component';

export const routes: Routes = [
  { path: '', redirectTo: 'register', pathMatch: 'full' },
  { path: 'register', component: RegisterComponent },
  { path: 'courses', component: AvailableCoursesComponent },
  { path: 'enrolled', component: EnrolledStudentsComponent }
];