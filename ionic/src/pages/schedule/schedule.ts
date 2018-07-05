import { Component } from '@angular/core';
import { IonicPage, NavController,AlertController, NavParams } from 'ionic-angular';
import { ListEventProvider } from '../../providers/list-event/list-event';
import Event from '../model/event.model';
import { EventsPage } from '../events/events';


@IonicPage()
@Component({
  selector: 'page-schedule',
  templateUrl: 'schedule.html',
})
export class SchedulePage {

  selectedEvent: Event;
  buffer : Array<any>;
  searchType: 'nom' | 'dateDebut' = 'nom';
  searchValue: string='';
  events: Event[];

  constructor(public navCtrl: NavController, public navParams: NavParams, public alertCtrl: AlertController, public api:ListEventProvider ) {
    this.events=api.getEvents();
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad SchedulePage');
  }

  search(){
    this.events=this.buffer.filter((event)=>{
      let nom = event[this.searchType].toLowerCase(); 
      return nom.startsWith(this.searchValue);
    })
    if(this.events.length==0){
      this.alertCtrl.create({
        title :'Hum!',
        subTitle: 'Aucun utilisateur trouvé',
        buttons: ['ok']
      }).present();
    }
  }

  

  goToDetail(event:Event) {
    this.selectedEvent=event;
    this.navCtrl.push(EventsPage);
  }
}
