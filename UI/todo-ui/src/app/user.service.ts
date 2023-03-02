import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "./user";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl="http://localhost:8080/api/v1/user/user";

  constructor(private httpClient: HttpClient) { }

  public getAllUsers(): Observable<User[]>{
    return this.httpClient.get<User[]>(`${this.baseUrl}`);
  }

  public deleteUser(userId: number) {
    return this.httpClient.delete("http://localhost:8080/api/v1/user/delete/"+ userId);
  }

  public createUser(user:User) {
    return this.httpClient.post("http://localhost:8080/api/v1/user/user", user);
  }

  public updateUser(user:User) {
    return this.httpClient.put("http://localhost:8080/api/v1/user/user", user);
  }
}
