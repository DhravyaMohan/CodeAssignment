import { Component, OnInit } from '@angular/core';
import { UpdateUserService } from '../update-user.service';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {
  usersData: any;
  currentUser: any = {};

  constructor(
    private updateUserService: UpdateUserService
  ) { }

  ngOnInit() {
    this.updateUserService.getAllUsers().subscribe((data: any) => {
      this.usersData = data;
    })
  }
  userForm = new FormGroup({
    id: new FormControl(''),
    firstName: new FormControl(''),
    lastName: new FormControl(''),
    emailId: new FormControl(''),
    address: new FormControl(''),
    contactNo: new FormControl(''),
    age: new FormControl(''),
  });

  update(){
    let json = JSON.stringify({
      id: this.userForm.value.id,
      firstName: this.userForm.value.firstName,
      lastName: this.userForm.value.lastName,
      emailId: this.userForm.value.emailId,
      address: this.userForm.value.address,
      contactNo: this.userForm.value.contactNo,
      age: this.userForm.value.age
    });
    this.updateUserService.updateUser(json).subscribe(data => {
      alert("successfully Updated");
    })
  }
  editUser(user){
    this.currentUser = user;
  }
  delete(user){
    this.updateUserService.deleteUser(user.id).subscribe(data =>{
    window.location.reload();
    })
  }

}
