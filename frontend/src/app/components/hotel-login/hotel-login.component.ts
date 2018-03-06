import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms/src/directives/ng_form';
import {LoginVM} from './loginVM';
import {LoginService} from '../../servics/login.service';

@Component({
  selector: 'app-hotel-login',
  templateUrl: './hotel-login.component.html',
  styleUrls: ['./hotel-login.component.css']
})
export class HotelLoginComponent implements OnInit {

  private loginSuccess = 0;
  public loginVM :any=LoginVM;


  constructor(private _loginService:LoginService) { }

  ngOnInit() {
  }
  
  login(loginForm:NgForm):void{
    this.loginVM.username = loginForm.value.username;
    this.loginVM.password = loginForm.value.password
    console.log('After Called : '+this._loginService.login(this.loginVM));
  }
}
