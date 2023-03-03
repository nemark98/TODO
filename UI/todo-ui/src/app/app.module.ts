import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import { UserListComponent } from './user/user-list/user-list.component';
import { UserModalComponent } from './user/user-modal/user-modal.component';
import { TodoTaskListComponent } from './todoTask/todo-task-list/todo-task-list.component';
import { TodoTaskModalComponent } from './todoTask/todo-task-modal/todo-task-modal.component';
import {MatTableModule} from '@angular/material/table';
import {MatFormFieldModule} from "@angular/material/form-field";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from "@angular/material/button";
import { QuestionModalComponent } from './todoTask/question-modal/question-modal.component';
import {MatDialogModule} from '@angular/material/dialog';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatInputModule} from '@angular/material/input';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {TodoTaskListModalComponent} from './todoTask/todo-task-list-modal/todo-task-list-modal.component';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule} from "@angular/material/core";

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    UserModalComponent,
    TodoTaskListComponent,
    TodoTaskModalComponent,
    QuestionModalComponent,
    TodoTaskListModalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MatTableModule,
    MatFormFieldModule,
    MatIconModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatDialogModule,
    MatSnackBarModule,
    MatToolbarModule,
    MatInputModule,
    FormsModule,
    ReactiveFormsModule,
    MatDatepickerModule,
    MatNativeDateModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
