import { Component, OnInit } from '@angular/core';
import { Student } from '../student';
import { StudentService } from '../student.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrls: ['./update-student.component.css']
})
export class UpdateStudentComponent implements OnInit {

  constructor(private studentService: StudentService, private route: ActivatedRoute,
    private router : Router) { }
  student: Student={id:0,name:"", grp:"", age:0}
  id:number=0;

  ngOnInit(): void {
    this.id= this.route.snapshot.params['id']; 
    this.studentService.getStudentById(this.id).subscribe(data=>{
      this.student=data
    },
        error=>console.log(error));
  
  }
  onSubmit(){
    this.studentService.updateStudent(this.id,this.student).subscribe(data=>{
      this.goToStudentList()
    })
  }
  goToStudentList(){
    this.router.navigate(['/students'])

  }
  

}
