import {Component, Inject} from '@angular/core';
import {User} from "../../user";
import {UserService} from "../../user.service";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {TodoTask} from "../../todo-task";
import {TodoTaskService} from "../../todo-task.service";

@Component({
  selector: 'app-todo-task-modal',
  templateUrl: './todo-task-modal.component.html',
  styleUrls: ['./todo-task-modal.component.css']
})
export class TodoTaskModalComponent {

  currentTodoTask:TodoTask;
  title:String;

  constructor(private todoTaskService: TodoTaskService,
              public dialogRef: MatDialogRef<TodoTaskModalComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any) {

    this.currentTodoTask = data.todoTask;
    this.title = "Please fill out the brackets!";
  }

  createTodoTask(todoTask:TodoTask){
    let user:User = new User;
    user.id = this.data.userId;
    todoTask.user = user;
    this.todoTaskService.createTodoTask(todoTask).subscribe(data=> {
      if(data){
        this.dialogRef.close(data);
      }
    })
  }

  updateTodoTask(todoTask:TodoTask){
    this.todoTaskService.updateTodoTask(todoTask).subscribe(data=> {
      if(data){
        this.dialogRef.close(data);
      }
    })
  }

  submitForm(todoTask:TodoTask) {
    if(todoTask.id) {
      this.updateTodoTask(todoTask);
    } else {
      this.createTodoTask(todoTask);
    }
  }

  close(){
    this.dialogRef.close(null);
  }
}
