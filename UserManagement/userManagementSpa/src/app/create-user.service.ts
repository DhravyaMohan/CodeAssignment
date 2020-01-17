import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  })
}

@Injectable({
  providedIn: 'root'
})
export class CreateUserService {
	registerUrl = '/userManagement/users/createuser'
	constructor(private http: HttpClient) { }
	
	createUser(userForm:any): Observable<any>{
    return this.http.post<any>(this.registerUrl,userForm,httpOptions)
  }
}
