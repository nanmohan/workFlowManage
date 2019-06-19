import { Role } from './role';
import { Team } from './team';
import { Task } from './task';

export class User {
    id: number;
    username: string;
    password: string;
    role: Role;
    team: Team;
    task: Task[];
}