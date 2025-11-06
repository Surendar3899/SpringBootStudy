import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { ApiService } from './services/api.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, HttpClientModule],
  template: `
    <div class="container">
      <h1>{{ title }}</h1>
      <p *ngIf="message">{{ message }}</p>
      <p *ngIf="!message">Loading...</p>
    </div>
  `,
  styles: [`
    .container {
      text-align: center;
      font-family: Arial, sans-serif;
      margin-top: 60px;
    }
    h1 { color: #1976d2; }
  `]
})
export class AppComponent implements OnInit {
  title = 'Angular + Spring Boot Demo';
  message = '';

  constructor(private api: ApiService) {}

  ngOnInit() {
    this.api.getMessage().subscribe({
      next: (data) => this.message = data,
      error: (err) => this.message = 'Error connecting to backend 😢'
    });
  }
}
