import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { User } from '../_models';

const httpOptions = {
    headers: new HttpHeaders({ 
      'Access-Control-Allow-Origin':'*',
      'Access-Control-Allow-Methods': '*', 
      'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token, content-type',
    })
  };

@Injectable({ providedIn: 'root' })
export class AuthenticationService {
    constructor(private http: HttpClient) { }    

    login(username: string, password: string) {
        return this.http.post<any>(`http://localhost:8090/work-flow/api/user/${username}/login/${password}`, { username, password }, httpOptions)
            .pipe(map(user => {
                // login successful if there's a jwt token in the response
                if (user ) {
                    // store user details and jwt token in local storage to keep user logged in between page refreshes
                    localStorage.setItem('currentUser', JSON.stringify(user));
                }

                return user;
            }));
    }

    getAllUser(){
        return this.http.get<any>(`http://localhost:8090/work-flow/api/user`).pipe(map(allUser=>{
            if(allUser){
                localStorage.setItem('allUser',JSON.stringify(allUser));
            }
            
        }))
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
    }
}