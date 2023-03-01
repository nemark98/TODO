import { Component } from '@angular/core';
import {User} from "./user";
import {UserService} from "./user.service";
import {MatTableDataSource} from "@angular/material/table";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'todo-ui';
  }
