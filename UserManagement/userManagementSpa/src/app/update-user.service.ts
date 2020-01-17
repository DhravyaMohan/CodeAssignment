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

export class UpdateUserService {

	usersUrl = '/userManagement/users/getallusers';
	deleteUrl ='/userManagement/users/deleteuser/';
	updateUrl = '/userManagement/users/updateuser';
	
	constructor(private http: HttpClient) { }
	
  getAllUsers(): Observable<any>{
    return this.http.get<any>(this.usersUrl,httpOptions);
  }
  deleteUser(id): Observable<any>{
    return this.http.delete<any>(this.deleteUrl+id,httpOptions);
  }
  updateUser(user): Observable<any>{
    return this.http.put<any>(this.updateUrl,user,httpOptions);
  }

}
