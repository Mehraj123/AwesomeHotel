import { Injectable } from '@angular/core';
import {Http, Response, Headers, RequestOptions} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import {LoginVM} from '../loginVM';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { HotelLoginComponent } from 'app/components/hotel-login/hotel-login.component';

@Injectable()
export class LoginService{

    private baseURL : string='http://localhost:8080/users'; 
    private headers = new Headers({'Content-Type':'application/json'});
    private options = new RequestOptions({headers:this.headers});
    constructor(private _http:Http) { }


    login(vm:LoginVM){
       console.log(vm.username+", "+vm.password);
    }

}