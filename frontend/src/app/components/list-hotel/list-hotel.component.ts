import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router'
import {HotelService} from '../../servics/hotel.service';
import {Hotel} from '../../hotel'; 
import { error } from 'util';

@Component({
  selector: 'app-list-hotel',
  templateUrl: './list-hotel.component.html',
  styleUrls: ['./list-hotel.component.css']
})
export class ListHotelComponent implements OnInit {

  private hotels : Hotel[];

  constructor(private _hotelService:HotelService,public router: Router) { }

  ngOnInit() {
    this._hotelService.getHotels().subscribe((hotels)=>{
          this.hotels=hotels.data;
    }, (error)=>{
      console.log(error);
    }) 
  }
  
  deleteHotel(hotel:Hotel){
    console.log("Deleting hotel "+hotel)
    this._hotelService.deleteHotel(hotel.id).subscribe((date)=>{
      this.hotels.splice(this.hotels.indexOf(hotel),1);
    },(error)=>{
      console.log("Error occured while deletig hotel : "+error);
    })
  }

  updateHotel(hotel:Hotel){
    console.log(hotel)
  }

  createNewHotel(){
    console.log('Creating new hotel');
    this.router.navigate(['createHotel']);
  }
}
