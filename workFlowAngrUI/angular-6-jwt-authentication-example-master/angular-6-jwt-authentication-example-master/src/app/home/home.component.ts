import { Component, OnInit } from '@angular/core';
import { first, map } from 'rxjs/operators';
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
    isChanged : boolean;
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
    
    }
    public saveTask():void{
        this.isChanged = false
        console.log("inside save");
        if(this.isUser){
            console.log("inside first if");
            this.user.assignedTask.forEach(element => {
                console.log(element.task.taskName);
                console.log(this.savedTask);
                if(this.savedTask[element.task.taskId] == "on"){
                    console.log("inside second if");
                    this.isChanged=true;
                    element.task.status.statusId = 3;
                    element.task.status.statusName ="COMPLETED";
                    console.log("i'm gonna save");
                }
            });
        }else{
            this.user.task.forEach(element => {
                if(this.saveTask[element.taskId] ){
                    this.isChanged=true;
                }
            });
        }
        if(this.isChanged){
            console.log(this.user);
            this.userService.saveUser(this.user).subscribe(user=>{
                this.user = user;
            });
        }
       }
}