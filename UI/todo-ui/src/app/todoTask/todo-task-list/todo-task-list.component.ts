import {Component, Input} from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {MatSnackBar} from "@angular/material/snack-bar";
import {MatTableDataSource} from "@angular/material/table";
import {QuestionModalComponent} from "../question-modal/question-modal.component";
import {TodoTaskListModalComponent} from "../todo-task-list-modal/todo-task-list-modal.component";
import {TodoTaskService} from "../../todo-task.service";
import {TodoTask} from "../../todo-task";
import {TodoTaskModalComponent} from "../todo-task-modal/todo-task-modal.component";

@Component({
  selector: 'app-todo-task-list',
  templateUrl: './todo-task-list.component.html',
  styleUrls: ['./todo-task-list.component.css']
})
export class TodoTaskListComponent {

  @Input()
  userId:number;

  title = "todoTaskListTable"

  listOfTodoTasks!: TodoTask[];

  constructor(private todoTaskService: TodoTaskService,
              public matDialogModule: MatDialog,
              public snackBar: MatSnackBar) {
  }

  ngOnInit() {
    this.fetchTask();

  }
  dataSource: any;
  fetchTask() {
    this.todoTaskService.getAllByUser(this.userId).subscribe(data => {
      this.listOfTodoTasks = data
      this.dataSource = new MatTableDataSource(this.listOfTodoTasks);
    })
  }

  deleteTodoTask(todoTaskId:number){
    this.todoTaskService.deleteTodoTask(todoTaskId).subscribe(data => {
      if(data) {
        const indexOfObject = this.listOfTodoTasks.findIndex((item:TodoTask) => {
          return item.id === todoTaskId;
        })
        if (indexOfObject !== -1) {
          this.listOfTodoTasks.splice(indexOfObject, 1);
          this.dataSource = new MatTableDataSource(this.listOfTodoTasks);
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

  openQuestionModal(todoTaskId:number){
    let dialogRef = this.matDialogModule.open(QuestionModalComponent, {
      data: "Are you sure you want to delete it?",
    })
    dialogRef.afterClosed().subscribe(closeResult =>{
      if(closeResult) {
        this.deleteTodoTask(todoTaskId);
      }
    })
  }

  openTodoTaskModal(todoTask?:TodoTask) {
    if(!todoTask){
      todoTask = new TodoTask();
    }
    let dialogRef = this.matDialogModule.open(TodoTaskModalComponent, {
      data: {todoTask:todoTask, userId:this.userId}
    })
    dialogRef.afterClosed().subscribe(closeResult =>{
      if(closeResult != null) {
        let objectIndex = this.listOfTodoTasks.findIndex((item:TodoTask) => {
          return item.id == closeResult.id
        });
        if(objectIndex != -1) {
          this.listOfTodoTasks[objectIndex] = closeResult;
        } else {
          this.listOfTodoTasks.push(closeResult);
        }
        this.dataSource = new MatTableDataSource(this.listOfTodoTasks);
      }
    })
  }

  showTaskList(todoTaskId:number){
    let dialogRef = this.matDialogModule.open(TodoTaskListModalComponent, {
      data: todoTaskId,
    })
  }

  displayedColumns: string[] = ['id', 'title', 'description', 'due_date', 'status', 'edit', 'delete'];
}
