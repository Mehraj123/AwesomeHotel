import { Injectable } from '@angular/core';
import {Http, Response, Headers, RequestOptions} from '@angular/http';
import {Observable} from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable()
export class HotelService {
  private baseURL : string='http://localhost:8080'; 
  private headers = new Headers({'Content-Type':'application/json'});
  constructor(private _http:Http) { }

  getHotels(){
    this.headers.append('Authorization',localStorage.getItem('Token'));
    console.log('Get Tokan calling backend '+localStorage.getItem('Token'));
    let options = new RequestOptions({headers:this.headers});
    console.log(options.headers);
    return this._http.get(this.baseURL+'/hotels', options)
    .map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  deleteHotel(id:string){
    return this._http.delete(this.baseURL+'/hotels/'+id)
    .map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  errorHandler(error:Response){
    return Observable.throw(error||"SERVER ERROR"); 
  }

  updateHotel(){

  }
}
