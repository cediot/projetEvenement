import { Component } from '@angular/core';
import Event from '../../pages/model/event.model';
import { NavController, NavParams } from 'ionic-angular';


@Component({
  selector: 'event-details',
  templateUrl: 'event-details.html'
})
export class EventDetailsComponent {

  selectedEvent : Event;
  


  constructor(public navCtrl: NavController, public navParams: NavParams) {
    this.selectedEvent=this.navParams.get('selectedEvent');
    console.log(this.selectedEvent);
    
  }

  
}
