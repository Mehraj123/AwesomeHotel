import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms/src/directives/ng_form';
import { LoginVM } from './loginVM';
import { LoginService } from '../../servics/login.service';
import { Response } from '../../Response';

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

  constructor(private _loginService: LoginService) { }

  ngOnInit() {
  }

  login(loginForm: NgForm) {
    this.show=true;
    console.log('UserName : ' + this.loginVM.username);
    console.log('UserName : ' + this.loginVM.password);
    this._loginService.login(this.loginVM)
      .subscribe((response) => {
        this.response = <Response>response;
      }, (error) => {
        console.log(error);
        this.response.success=false;
      });
  }

  hideAlert(){
    if(this.show)
    this.response.success=null;
    console.log('Clicked')
  }
}
