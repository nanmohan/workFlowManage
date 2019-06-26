import { Role } from "./role";
import { Team } from "./team";
import { Task } from "./task";
import { AssignedTask } from "./assignedTask";

export class User {
    userId: number;
    userName: string;
    password: string;
    role:Role;
    team:Team;
    assignedTask: AssignedTask;
    task:Task;
}