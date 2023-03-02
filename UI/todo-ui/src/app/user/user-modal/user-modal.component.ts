import { Component } from '@angular/core';
import {User} from "../../user";
import {UserService} from "../../user.service";

@Component({
  selector: 'app-user-modal',
  templateUrl: './user-modal.component.html',
  styleUrls: ['./user-modal.component.css']
})
export class UserModalComponent {

  constructor(private userService:UserService) {
  }

  dataSource: any;
  createUser(user:User){
    this.userService.createUser(user).subscribe(data=> {
      this.dataSource.push(data);
    })
  }
}
