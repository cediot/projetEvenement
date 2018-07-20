/// <reference types="googlemaps" />
import { MapsAPILoader, GoogleMapsAPIWrapper as GMapWrapper } from '@agm/core';
import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { Geolocation } from '@ionic-native/geolocation';
import { Observable } from 'rxjs/Observable';
// firebase services
import { AngularFireDatabase } from 'angularfire2/database';



const jsonEvent = [
  {
      "id": 4,
      "nom": "Jardin Vauban",
      "adresse": "Boulevard Vauban 59000 Lille",
      "tarif": "gratuit",
      "dateDebut": "2018-06-12 10:00:00",
      "dateFin": "2018-06-13 11:00:00",
      "validation":"ok", 
      "utilisateurId":"02"
  },
  {
      "id": 2,
      "nom": "Palais des beaux-arts de Lille",
      "adresse": "18 Bis Rue de Valmy, 59000 Lille",
      "tarif": "gratuit",
      "dateDebut": "2018-06-15 08:00:00",
      "dateFin": "2018-06-16 10:00:00",
      "validation":"ok", 
      "utilisateurId":"05"
  },
  {
      "id": 7,
      "nom": "UGC Cine Cite Lille",
      "adresse": "40 Rue de Bethune, 59800 Lille",
      "tarif": "10.00",
      "dateDebut": "2018-06-20 10:00:00",
      "dateFin": "2018-06-20 12:00:00",
      "validation": "ok",
      "utilisateurId":"02"
  },
  {
      "id": 9,
      "nom": "Gare de Lille-Saint-Sauveur",
      "adresse": "17 Boulevard Jean-Baptiste Lebas, 59800 Lille",
      "tarif": "gratuit",
      "dateDebut": "2018-07-01 20:00:00",
      "dateFin": "2018-07-01 21:00:00",
      "validation":"ok", 
      "utilisateurId":"04"
  },
  {
      "id": 6,
      "nom": "Beffroi de Lille",
      "adresse": "59800 Lille",
      "tarif": "gratuit",
      "dateDebut": "2018-06-28 15:00:00",
      "dateFin": "2018-06-28 16:00:00",
      "validation":"ok",
      "utilisateurId":"03"
  }
];



@Component({
  selector: 'page-home',
  templateUrl: 'home.html',

})
export class HomePage {
  map: any;
  title: string = 'My first AGM project';
  lat: number = 50.632035;
  lng: number = 3.059844;
  geocoder: any;
  private db: Observable<{}[]>;

  constructor(
    public navCtrl: NavController, 
    private geolocation: Geolocation, 
    private mapsAPILoader: MapsAPILoader, 
    fireBase:AngularFireDatabase ) {

    this.geolocation.getCurrentPosition().then((resp) => {
      this.lat = resp.coords.latitude
      this.lng = resp.coords.longitude
    }).catch((error) => {
      console.log('Error getting location', error);
    });

    this.db = fireBase.list('evenements').valueChanges();

    this.db.subscribe(function(data) {
      jsonEvent.forEach(element => {
        data.push(element)
      });
      
    })
  }

  public onMapReady(map) {
    this.map = map;

    this.mapsAPILoader.load().then(() => {
      this.geocoder = new google.maps.Geocoder();
    });
  }

  
  /**
   * 
   * @param adresse 
   * @param fct : callback 
   */
  public adresseToPos(adresse: string, fct: (pos:any)=> any ) {
    if(this.geocoder) {
      this.geocoder.geocode({ 'address': "lyon france" },  (results, status) => {
        let pos = results[0].geometry.location;
        console.log(pos.lat(), ' : ', pos.lng());
        fct(pos);
      });
    }
  }

}