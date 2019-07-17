import { Status } from "./status";
import { User } from "./user";
import { AssignedTask } from "./assignedTask";

export class Task{
    taskId:number;
    taskName: string;
    taskOwner : User;
    assignedUser: User;
    status : Status;
}