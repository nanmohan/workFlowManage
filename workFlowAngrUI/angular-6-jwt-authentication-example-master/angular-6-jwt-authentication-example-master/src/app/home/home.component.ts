import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs/operators';
//import {MatTableDataSource} from '@angular/material';

import { User } from '../_models';
import { UserService, AuthenticationService } from '../_services';
import { AssignedTask } from '../_models/assignedTask';
import { DisplayObject } from '../_models/displayObject';

@Component({templateUrl: 'home.component.html'})
export class HomeComponent implements OnInit {
    user: User;   
    users : User[];   
    isUser:boolean;
    isDisabled : boolean;
    savedTask=new Map<number, string>();
    
    constructor(private userService: UserService) {}

    /*dispObjPopulate(currentUser: User, allUsers:User[] ){
        currentUser.task.forEach(currentTask => {
            currentAssignTask : AssignedTask[];
            currentAssignTask = allUsers.find(x => x. == this.personId);
        });
    }*/

    ngOnInit() {
        this.user =JSON.parse( localStorage.getItem('currentUser'));           
        if(this.user.role.roleName.match("MANAGER")){
            this.isDisabled = true;
            this.isUser =false;  
            this.userService.getAll().pipe(first()).subscribe(users => { 
                this.users = users;                 
            });
     
        }else{
            this.isUser =true;
        }
    }
   public checkValue(checked:string,taskId:number):void{
     this.savedTask [taskId]=checked;
     console.log(this.savedTask);
    }
    public saveTask():void{
              console.log(this.savedTask);
       }
}