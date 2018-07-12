import { Component } from '@angular/core';
import { IonicPage, NavController, AlertController, NavParams } from 'ionic-angular';
import { Http } from '@angular/http';
import { Observable } from 'rxjs';

import Event from '../model/event.model';
import { EventsPage } from '../events/events';
import { EventDetailsProvider } from '../../providers/event-details/event-details';


@IonicPage()
@Component({
  selector: 'page-schedule',
  templateUrl: 'schedule.html',
})
export class SchedulePage {

  selectedEvent: Event;
  buffer: Array<any>;
  searchType: 'nom' | 'dateDebut' = 'nom';
  searchValue: string = '';
  events: Event[];

  constructor(private http: Http, public navCtrl: NavController, public navParams: NavParams, public alertCtrl: AlertController, public api: EventDetailsProvider) {

  }

  ionViewDidLoad() {
    let event = this.api.getEvents().subscribe(response => { this.events = response; });

  }

  search() {
    this.events = this.buffer.filter((event) => {
      let nom = event[this.searchType].toLowerCase();
      return nom.startsWith(this.searchValue);
    })
    if (this.events.length == 0) {
      this.alertCtrl.create({
        title: 'Hum!',
        subTitle: 'Aucun utilisateur trouvé',
        buttons: ['ok']
      }).present();
    }
  }


  goToDetail(event: Event) {
    this.selectedEvent = event;
    console.log(event);

    this.navCtrl.push(EventsPage, { 
      event 
    });

    /*s'ecris aussi  this.navCtrl.push(EventsPage, { 
      selectedEvent: Event 
    }); rencerra un objet event vide*/
  }
}
