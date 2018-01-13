import { Component, OnInit } from '@angular/core';
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

  constructor(private _hotelService:HotelService) { }

  ngOnInit() {
    this._hotelService.getHotels().subscribe((hotels)=>{
          this.hotels=hotels.data;
          console.log(hotels);
    }, (error)=>{
      console.log(error);
    }) 
  }

}
