import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms/src/directives/ng_form';
import { LoginVM } from './loginVM';
import { LoginService } from '../../servics/login.service';
import { Response } from '../../Response';
import {Router} from '@angular/router';

@Component({
  selector: 'app-hotel-login',
  templateUrl: './hotel-login.component.html',
  styleUrls: ['./hotel-login.component.css']
})
export class HotelLoginComponent implements OnInit {

  private loginSuccess = 0;
  public loginVM: LoginVM = new LoginVM();
  private response: Response = new Response();
  public show:boolean=false;

  constructor(private _loginService: LoginService,  public router: Router) { 
 
  }

  ngOnInit() {
  }

  login(loginForm: NgForm) {
    this.show=true;
    console.log('UserName : ' + this.loginVM.username);
    console.log('UserName : ' + this.loginVM.password);
    this._loginService.login(this.loginVM)
      .subscribe((response) => {
        localStorage.setItem('Token',response.headers.get('authorization'));
        this.response = <Response>response;
        this.router.navigate(['hotels']);
      }, (error) => {
        console.log(error);
        this.response.success=false;
      });
  }

  hideAlert(){
    if(this.show)
    this.response.success=null;
  }
}
