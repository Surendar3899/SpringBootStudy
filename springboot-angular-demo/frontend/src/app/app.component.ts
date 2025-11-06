import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { ApiService } from './services/api.service';
import { MenuComponent } from "./component/menu/menu.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, HttpClientModule, MenuComponent],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'Angular + Spring Boot Demo';
  message = '';

  constructor(private api: ApiService) {}

  ngOnInit() {
    this.api.getMessage().subscribe({
      next: (data) => this.message = data,
      error: (err) => this.message = '❌ Failed to connect to backend'
    });
  }
}
