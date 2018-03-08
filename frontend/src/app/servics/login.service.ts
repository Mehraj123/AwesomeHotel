import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { LoginVM } from '../../../src/app/components/hotel-login/loginVM';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { HotelLoginComponent } from 'app/components/hotel-login/hotel-login.component';

@Injectable()
export class LoginService {

    private baseURL: string = 'http://localhost:8080/users';
    private headers = new Headers({ 'Content-Type': 'application/json' });
    private options = new RequestOptions({ headers: this.headers });
    constructor(private _http: Http) { }

    login(vm: LoginVM) {
       return this._http.post(this.baseURL + '/login', 
        {
            "username":vm.username,
            "password" : vm.password
        }
        ,this.options)
        .map((response:Response)=>response)
        .catch(this.errorHandler);
    }

    errorHandler(error:Response){
        return Observable.throw(error||"SERVER ERROR LoginService"); 
      }
}