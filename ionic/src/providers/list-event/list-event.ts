import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import Event from '../../pages/model/event.model';





@Injectable()
export class ListEventProvider {

  private events : Array<any>;

  constructor() {
    this.events=new Array<any>();
   this.events=[{
      id: 1,
      nom: "Jardin Vauban",
      adresse: "Boulevard Vauban 59000 Lille",
      tarif: "gratuit",
      dateDebut: "2018-06-12 10:00:00",
      dateFin: "2018-06-13 11:00:00",
      validation: 1,
      utilisateurId: 2
    },
   {
      id: 2,
      nom: "UGC Ciné Cité Lille",
      adresse: "40 Rue de Béthune, 59800 Lille",
      tarif: "10.00",
      dateDebut: "2018-06-20 10:00:00",
      dateFin: "2018-06-20 12:00:00",
      validation: 1,
      utilisateurId: 3
    },
   {
      id: 3,
      nom: "Gare de Lille-Saint-Sauveur",
      adresse: "17 Boulevard Jean-Baptiste Lebas, 59800 Lille",
      tarif: "gratuit",
      dateDebut: "2018-07-01 20:00:00",
      dateFin: "2018-07-01 21:00:00",
      validation: 1,
      utilisateurId: 1
    }];
   
    console.log('Hello ListEventProvider Provider');
  }

  getEvents():Array<Event>{
    return this.events;
  }
}
