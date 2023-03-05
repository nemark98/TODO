import {Component, Inject} from '@angular/core';
import {User} from "../../user";
import {UserService} from "../../user.service";
import {QuestionModalComponent} from "../../todoTask/question-modal/question-modal.component";
import {MatTableDataSource} from "@angular/material/table";
import {MAT_DIALOG_DATA, MatDialogRef, MatDialog} from "@angular/material/dialog";

@Component({
  selector: 'app-user-modal',
  templateUrl: './user-modal.component.html',
  styleUrls: ['./user-modal.component.css']
})
export class UserModalComponent {

  currentUser:User;
  title:String;

  constructor(private userService:UserService,
              public dialogRef: MatDialogRef<UserModalComponent>,
              @Inject(MAT_DIALOG_DATA) public data: User) {

    this.currentUser = data;
    this.title = "Please fill out the brackets!";
  }

  createUser(user:User){
    this.userService.createUser(user).subscribe(data=> {
    if(data){
      this.dialogRef.close(data);
    }
    })
  }

  updateUser(user:User){
    this.userService.updateUser(user).subscribe(data=> {
      if(data){
        this.dialogRef.close(data);
      }
    })
  }

  // if there is input id then update otherwise create
  submitForm(user:User) {
    if(user.id) {
      this.updateUser(user);
    } else {
      this.createUser(user)
    }
  }

  close(){
    this.dialogRef.close(null);
  }
}
