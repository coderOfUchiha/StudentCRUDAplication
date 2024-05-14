import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from './student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private baseUrl = "http://localhost:8080"
  constructor(private httpClient: HttpClient) { }
  getStudentList(): Observable<Student[]>{
    return this.httpClient.get<Student[]>(`${this.baseUrl}`);
  }
  addStudent(student: Student): Observable<Object>{
    return this.httpClient.post(`${this.baseUrl}/${"students"}`, student)
  }
  getStudentById(id:number): Observable<Student>{
      return this.httpClient.get<Student>(`${this.baseUrl}/${"students"}/${id}`);
  }
  updateStudent(id:number, student:Student):Observable<Object>{
    return this.httpClient.put(`${this.baseUrl}/${"students"}/${id}`, student)
  }
  deleteStudent(id:number):Observable<object>{
    return this.httpClient.delete(`${this.baseUrl}/${"students"}/${id}`);
  }

}
