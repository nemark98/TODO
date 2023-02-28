import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import { UserListComponent } from './user/user-list/user-list.component';
import { UserModalComponent } from './user/user-modal/user-modal.component';
import { TodoTaskListComponent } from './todoTask/todo-task-list/todo-task-list.component';
import { TodoTaskModalComponent } from './todoTask/todo-task-modal/todo-task-modal.component'

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    UserModalComponent,
    TodoTaskListComponent,
    TodoTaskModalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
