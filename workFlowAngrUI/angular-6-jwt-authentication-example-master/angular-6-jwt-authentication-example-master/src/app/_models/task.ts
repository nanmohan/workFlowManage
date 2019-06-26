import { Status } from "./status";
import { User } from "./user";

export class Task{
    taskId:number;
    taskName: string;
    taskOwner : User;
    status : Status;
}