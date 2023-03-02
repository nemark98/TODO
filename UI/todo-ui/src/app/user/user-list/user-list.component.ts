import {Component, OnInit} from '@angular/core';
import {User} from "../../user";
import {UserService} from "../../user.service";
import {MatTableDataSource} from "@angular/material/table";
import {MatDialog, MatDialogRef ,MAT_DIALOG_DATA} from '@angular/material/dialog';
import {QuestionModalComponent} from "../../todoTask/question-modal/question-modal.component";
import {MatSnackBar} from '@angular/material/snack-bar';
import {UserModalComponent} from "../user-modal/user-modal.component";
import {TodoTaskListComponent} from "../../todoTask/todo-task-list/todo-task-list.component";
import {TodoTaskListModalComponent} from "../../todoTask/todo-task-list-modal/todo-task-list-modal.component";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  title = "userListTable"

  listOfUsers!: User[];

  constructor(private userService: UserService,
              public matDialogModule: MatDialog,
              public snackBar: MatSnackBar) {
  }

  ngOnInit() {
    this.fetchUser();

  }
dataSource: any;
  fetchUser() {
    this.userService.getAllUsers().subscribe(data => {
      this.listOfUsers = data
      this.dataSource = new MatTableDataSource(this.listOfUsers);
    })
  }

  deleteUser(userId:number){
    this.userService.deleteUser(userId).subscribe(data => {
      if(data) {
      const indexOfObject = this.listOfUsers.findIndex((item:User) => {
        return item.id === userId;
      })
      if (indexOfObject !== -1) {
        this.listOfUsers.splice(indexOfObject, 1);
        this.dataSource = new MatTableDataSource(this.listOfUsers);
      }} else {
        this.snackBar.open("Hiba történt!", '', {
          duration: 4000,
          verticalPosition:'top',
          horizontalPosition:'right',
          panelClass: ['red-snackbar']
        });
      }
    })
  }

  openQuestionModal(userId:number){
    let dialogRef = this.matDialogModule.open(QuestionModalComponent, {
      data: "Are you sure you want to delete it?",
    })
    dialogRef.afterClosed().subscribe(closeResult =>{
      if(closeResult) {
        this.deleteUser(userId);
      }
    })
  }

  openAddUserModal(user?:User) {
    if(!user){
      user = new User();
    }
    let dialogRef = this.matDialogModule.open(UserModalComponent, {
      data: user
    })
    dialogRef.afterClosed().subscribe(closeResult =>{
      if(closeResult != null) {
        let objectIndex = this.listOfUsers.findIndex((item:User) => {
          return item.id == closeResult.id
        });
        if(objectIndex != -1) {
          this.listOfUsers[objectIndex] = closeResult;
        } else {
          this.listOfUsers.push(closeResult);
        }
        this.dataSource = new MatTableDataSource(this.listOfUsers);
      }
    })
  }

  showTaskList(userId:number){
    let dialogRef = this.matDialogModule.open(TodoTaskListModalComponent, {
      height: "600px",
      width: "800px",
      minHeight: "600px",
      minWidth: "800px",
      data: userId,
    })
  }


  displayedColumns: string[] = ['id', 'first_name', 'last_name', 'username', 'email', 'edit', 'delete', 'todos'];
}
