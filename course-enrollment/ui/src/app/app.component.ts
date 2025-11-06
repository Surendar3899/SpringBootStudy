import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  template: `
    <h1>Course Enrollment System</h1>
    <nav>
      <a routerLink="/courses">Available Courses</a> |
      <a routerLink="/enroll">Enroll</a>
    </nav>
    <hr>
    <router-outlet></router-outlet>
  `,
  styles: [`
    nav a { margin-right: 10px; }
  `]
})
export class AppComponent {}
