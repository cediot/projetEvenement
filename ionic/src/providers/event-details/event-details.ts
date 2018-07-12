import { Http } from '@angular/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
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
 

  constructor(private http: Http) {
    
  }

  getEvents(){
    return this.http.get('/assets/event.json').map(response => response.json());
    
  }
  

    // getEventByID(id: number){
    //   const event=this.events.find((e)=>{
    //     return e.id===id;
    //   });
    //   return event;
      
    // }

  }


