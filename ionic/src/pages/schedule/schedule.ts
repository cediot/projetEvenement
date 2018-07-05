import { Component } from '@angular/core';
import { IonicPage, NavController,AlertController, NavParams } from 'ionic-angular';


@IonicPage()
@Component({
  selector: 'page-schedule',
  templateUrl: 'schedule.html',
})
export class SchedulePage {

  events : Array<Object>;
  buffer : Array<Object>;
  searchType: 'nom' | 'dateDebut' = 'nom';
  searchValue: string='';

  constructor(public navCtrl: NavController, public navParams: NavParams, public alertCtrl: AlertController) {
    this.events=new Array<Object>();
    this.events.push({
      id: 1,
      nom: "Jardin Vauban",
      adresse: "Boulevard Vauban 59000 Lille",
      tarif: "gratuit",
      dateDebut: "2018-06-12 10:00:00",
      dateFin: "2018-06-13 11:00:00",
      validation: 1,
      utilisateurId: 2
    });
    this.events.push({
      id: 2,
      nom: "UGC Ciné Cité Lille",
      adresse: "40 Rue de Béthune, 59800 Lille",
      tarif: "10.00",
      dateDebut: "2018-06-20 10:00:00",
      dateFin: "2018-06-20 12:00:00",
      validation: 1,
      utilisateurId: 3
    });
    this.events.push({
      id: 3,
      nom: "Gare de Lille-Saint-Sauveur",
      adresse: "17 Boulevard Jean-Baptiste Lebas, 59800 Lille",
      tarif: "gratuit",
      dateDebut: "2018-07-01 20:00:00",
      dateFin: "2018-07-01 21:00:00",
      validation: 1,
      utilisateurId: 1
    });
    this.buffer= this.events.slice(0);
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

  goToDetail(events) {

    for (let event of events) {
     
      console.log(event);
    }
  }
}
