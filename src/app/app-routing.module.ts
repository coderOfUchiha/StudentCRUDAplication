import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentListComponent } from './student-list/student-list.component';
import { AddStudentComponent } from './add-student/add-student.component';
import { UpdateStudentComponent } from './update-student/update-student.component';

const routes: Routes = [
  {
    path:'students', component: StudentListComponent
    
  },
  {
    path:'add-student', component: AddStudentComponent
  },

  {
    path: '', redirectTo: 'students', pathMatch:'full'
  },
  {
    path:'update-student/:id', component:UpdateStudentComponent
  }
  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
