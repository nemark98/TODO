import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {TodoTask} from "./todo-task";

@Injectable({
  providedIn: 'root'
})
export class TodoTaskService {

  private baseUrl="http://localhost:8080/api/v1/todoTask";

  constructor(private httpClient: HttpClient) { }

  public getAllByUser(userId:number): Observable<TodoTask[]>{
    return this.httpClient.get<TodoTask[]>(`${this.baseUrl}` +"/findByUser/"+ userId);
  }

  public deleteTodoTask(taskId: number) {
    return this.httpClient.delete(`${this.baseUrl}`+ "/delete/" + taskId);
  }

  public createTodoTask(todoTask:TodoTask) {
    return this.httpClient.post(`${this.baseUrl}`+ "/todoTask", todoTask);
  }

  public updateTodoTask(todoTask:TodoTask) {
    return this.httpClient.put(`${this.baseUrl}`+ "/todoTask", todoTask);
  }
}
