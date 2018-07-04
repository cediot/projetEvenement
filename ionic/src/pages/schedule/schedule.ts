import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';


@IonicPage()
@Component({
  selector: 'page-schedule',
  templateUrl: 'schedule.html',
})
export class SchedulePage {

  events = [{
    id:1,
    nom:"Jardin Vauban",
    adresse:"Boulevard Vauban 59000 Lille",
    tarif:"gratuit",
    dateDebut:"2018-06-12 10:00:00",
    dateFin:"2018-06-13 11:00:00",
    validation:1,
    utilisateurId:2
    },
    {
    id:2,
    nom:"UGC Ciné Cité Lille",
    adresse:"40 Rue de Béthune, 59800 Lille",
    tarif:"10.00",
    dateDebut:"2018-06-20 10:00:00",
    dateFin:"2018-06-20 12:00:00",
    validation:1,
    utilisateurId:3
    },
    {
    id:3,
    nom:"Gare de Lille-Saint-Sauveur",
    adresse:"17 Boulevard Jean-Baptiste Lebas, 59800 Lille",
    tarif:"gratuit",
    dateDebut:"2018-07-01 20:00:00",
    dateFin:"2018-07-01 21:00:00",
    validation:1,
    utilisateurId:1
    }];

  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad SchedulePage');
  }

  goToDetail(events){
    for(let i=0; i<events.length;i++){
      console.log(events[i]);
    }
  }
}
