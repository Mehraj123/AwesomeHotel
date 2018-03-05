import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-hotel-login',
  templateUrl: './hotel-login.component.html',
  styleUrls: ['./hotel-login.component.css']
})
export class HotelLoginComponent implements OnInit {

  private loginSuccess = 1;

  constructor() { }

  ngOnInit() {
  }
  
  login(){
    console.log('Login Clicked');
  }
}
