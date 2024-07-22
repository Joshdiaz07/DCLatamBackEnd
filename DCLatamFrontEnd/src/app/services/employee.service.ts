import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private API_SERVER_EmployeeByID = "http://127.0.0.1:8080/DCLatamBackEnd/employeeById";
  private API_SERVER_EmployeesList = "http://127.0.0.1:8080/DCLatamBackEnd/employeesList";

  constructor(
    private httpClient: HttpClient
  ) { }


  public getEmployeeByID(): Observable<any>{
    return this.httpClient.get(this.API_SERVER_EmployeeByID);
  }

  public getEmployeesList(): Observable<any>{
    return this.httpClient.get(this.API_SERVER_EmployeesList);
  }


}
