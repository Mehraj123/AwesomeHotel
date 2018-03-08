import {Address} from './Address';

export class Hotel {
    id:string;
    name:string;
    pricePerNight: number;
    address:Address = new Address();
}
