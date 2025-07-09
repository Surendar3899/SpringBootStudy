import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  getCourses(): Observable<any> {
    return this.http.get(`${this.baseUrl}/courses`);
  }

  getEnrolledStudents(): Observable<any> {
    return this.http.get(`${this.baseUrl}/courses/enrolled`);
  }

  registerCourse(name: string, emailId: string, courseName: string): Observable<any> {
    console.log("registerCourse called")
    const params = new HttpParams()
      .set('name', name)
      .set('emailId', emailId)
      .set('courseName', courseName);
    
    return this.http.post(`${this.baseUrl}/courses/register`, null, { params, responseType: 'text' });
  }
}
