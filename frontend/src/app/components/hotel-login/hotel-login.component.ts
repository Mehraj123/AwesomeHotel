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
    console.log('Get Tokan ngOnInit '+localStorage.getItem('Token'));
    localStorage.clear();
    console.log('Get Tokan ngOnInit '+localStorage.getItem('Token'));
  }

  login(loginForm: NgForm) {
    this.show=true;
    console.log('UserName : ' + this.loginVM.username);
    console.log('UserName : ' + this.loginVM.password);
    this._loginService.login(this.loginVM)
      .subscribe((response) => {
        console.log('Received token after calling login UI : '+response.headers.get('authorization'));
        localStorage.setItem('Token',response.headers.get('authorization'));
        console.log('Get Tokan after setting '+localStorage.getItem('Token'));
        this.response = <Response>response;
        console.log(response);
        this.router.navigate(['hotels']);
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
