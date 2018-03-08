import { Component, OnInit } from '@angular/core';
import {Hotel} from '../../hotel';
import { HotelService } from '../../servics/hotel.service';

@Component({
  selector: 'add-hotel',
  templateUrl: './add-hotel.component.html',
  styleUrls: ['./add-hotel.component.css']
})
export class AddHotelComponent implements OnInit {

  public hotel:Hotel;

  constructor(private _hotelService: HotelService) { 
        this.hotel = new Hotel();                
  }

  ngOnInit() {
  }

  createNewHotel(){
    console.log('Hotel Submitted');
    console.log(this.hotel)
    this._hotelService.createHotel(this.hotel);
  }

}
