import {Component, OnInit} from '@angular/core';
import {User} from "../../user";
import {UserService} from "../../user.service";
import {MatTableDataSource} from "@angular/material/table";
import {MatDialog, MatDialogRef ,MAT_DIALOG_DATA} from '@angular/material/dialog';
import {QuestionModalComponent} from "../../todoTask/question-modal/question-modal.component";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  // users: User[];
  //
  // constructor(private userService: UserService) { }
  //
  // ngOnInit(): void {
  //   this.getUsers();
  // }
  //
  // private getUsers() {
  //   this.userService.getAllUsers().subscribe(data => {
  //     this.users = data;
  //   });
  // }

  title = "userListTable"

  listOfUsers!: User[];

  constructor(private userService: UserService,
              public matDialogModule: MatDialog) {
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
      const indexOfObject = this.listOfUsers.findIndex((object:User) => {
        return object.id === userId;
      })
      if (indexOfObject !== -1) {
        this.listOfUsers.splice(indexOfObject, 1);
        this.dataSource = new MatTableDataSource(this.listOfUsers);
      }} else {
        alert("Nem sikerült a törlés")
        //todo: hibakezelés megvalósítása pl.:errormodal "Törlés nem sikerült!"
      }
    })
  }

  openQuestionModal(userId:number){
    let dialogRef = this.matDialogModule.open(QuestionModalComponent, {
      data: "Biztos törölni szeretné?",
    })
    dialogRef.afterClosed().subscribe(closeResult =>{
      if(closeResult) {
        this.deleteUser(userId);
      }
    })
  }


  displayedColumns: string[] = ['id', 'first_name', 'last_name', 'username', 'email', 'edit', 'delete', 'todos'];
}
