import {User} from "./user";

export class TodoTask {
  id: number;
  description: string;
  title: string;
  status: string;
  due_date: Date;

  user:User;
}
