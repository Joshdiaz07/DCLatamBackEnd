import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EmployeeService } from './services/employee.service'
import { response } from 'express';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  
  employeeForm: FormGroup;  
  employeeObject: any;

  constructor(
    public fb: FormBuilder,
    public employeeService: EmployeeService
  ){

  }
  ngOnInit(): void {
    this.employeeForm = this.fb.group({
      id : ['',Validators.required],
      employee_name : ['',Validators.required],
      employee_salary : ['',Validators.required],
      employee_age : ['',Validators.required],
      profile_image : ['',Validators.required],
      employee_anual_salary : ['',Validators.required]
    });;
  }


  buscar():void{
    this.employeeService.getEmployeeByID().subscribe(resp=>{
      this.employeeObject = resp;
    },
    error=>{console.error(error)}
  );
  }
  


}


