import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {User} from "../../user";

@Component({
  selector: 'app-todo-task-list-modal',
  templateUrl: './todo-task-list-modal.component.html',
  styleUrls: ['./todo-task-list-modal.component.css']
})
export class TodoTaskListModalComponent {

  userId:number;

  constructor(public dialogRef: MatDialogRef<TodoTaskListModalComponent>,
              @Inject(MAT_DIALOG_DATA) public data:number) {

    this.userId = data;
  }
}
