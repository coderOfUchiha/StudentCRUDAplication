import { Component, OnInit } from '@angular/core';
import { Student } from '../student';
import { StudentService } from '../student.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent implements OnInit {
  student: Student= {id: 0, name: "", grp:"", age:0}

  constructor(private studentService: StudentService, private router: Router) { }

  ngOnInit(): void {
  }
  saveStudent(){
    this.studentService.addStudent(this.student).subscribe(data=>{
      console.log(data);
      this.goToStudentList();
    },
        error=>console.error(error));
  
  }
  goToStudentList(){
    this.router.navigate(['/students'])

  }
  onSubmit(){
    console.log(this.student)
    this.saveStudent()
  }

}
