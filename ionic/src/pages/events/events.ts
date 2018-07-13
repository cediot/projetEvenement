import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { Http } from '@angular/http';
import { Observable } from 'rxjs';
import { EventDetailsProvider } from '../../providers/event-details/event-details';


@IonicPage()
@Component({
  selector: 'page-events',
  templateUrl: 'events.html',
})
export class EventsPage {

  public event = {};

  id: number;
  nom: string;
  adresse: string;
  dateDebut: string;
  dateFin: string;


  constructor(public navCtrl: NavController, public navParams: NavParams, public api: EventDetailsProvider, private http: Http) {
    this.event=this.navParams.get('event');
    console.log(this.event);
  }

  ionViewDidLoad() {
    this.api.getEvents().subscribe(response => console.log(response));
  }

}
