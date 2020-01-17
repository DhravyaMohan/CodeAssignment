import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { CreateUserService } from '../create-user.service';


@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {

  constructor(
    private createUser: CreateUserService
  ) { }

  ngOnInit() {
  }
  userForm = new FormGroup({
    firstName: new FormControl(''),
    lastName: new FormControl(''),
    emailId: new FormControl(''),
    address: new FormControl(''),
    contactNo: new FormControl(''),
    age: new FormControl(''),
  });

  signup(){

    let json = JSON.stringify({
      firstName: this.userForm.value.firstName,
      lastName: this.userForm.value.lastName,
      emailId: this.userForm.value.emailId,
      address: this.userForm.value.address,
      contactNo: this.userForm.value.contactNo,
      age: this.userForm.value.age
    });

    this.createUser.createUser(json).subscribe(data => {
      alert("succesfully registered");
    })
  }

}
