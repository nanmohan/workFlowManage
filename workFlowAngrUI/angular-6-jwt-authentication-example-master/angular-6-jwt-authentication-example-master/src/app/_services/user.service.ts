import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';

import { User } from '../_models';
import { map } from 'rxjs/operators';

@Injectable({ providedIn: 'root' })
export class UserService {
    
    constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get<User[]>(`http://localhost:8090/work-flow/api/user`);
    }

    
    saveUser(currentUser:User){
        const headers = new HttpHeaders({'Content-Type':'application/json; charset=utf-8'});
        return this.http.put<User>(`http://localhost:8090/work-flow/api/user/save`, JSON.stringify(currentUser),{headers: headers}).pipe(map(user => {
            if (user ) {
                localStorage.setItem('currentUser', JSON.stringify(user));
            }
            return user;
        },(err: HttpErrorResponse) => {
            if (err.error instanceof Error) {
                console.log('Client-side error occured.');
            } else {
                console.log('Server-side error occured.');
            }
        }));
}
}