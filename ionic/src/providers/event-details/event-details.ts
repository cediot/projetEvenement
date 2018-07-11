import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import Event from '../../pages/model/event.model';



/*
  Generated class for the EventDetailsProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class EventDetailsProvider {

  event: Event;
 
    // id:number;
    // nom:string;
    // adresse:string;
    // tarif:string;
    // dateDebut:string;
    // dateFin:string;
    // validation:number;
    // utilisateurId:number;
   

  constructor(public http: HttpClient) {
    console.log('Hello EventDetailsProvider Provider');
  }

getEvent(){
  return this.event;
}
  

}
