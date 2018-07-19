import { MapsAPILoader, GoogleMapsAPIWrapper } from '@agm/core';
import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { Geolocation } from '@ionic-native/geolocation';

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

  constructor(public navCtrl: NavController, private geolocation: Geolocation, private mapsAPILoader: MapsAPILoader, _mapsWrapper: GoogleMapsAPIWrapper) {

    this.geolocation.getCurrentPosition().then((resp) => {
      this.lat = resp.coords.latitude
      this.lng = resp.coords.longitude
    }).catch((error) => {
      console.log('Error getting location', error);
    });

    let watch = this.geolocation.watchPosition();
    watch.subscribe((data) => {
      // data can be a set of coordinates, or an error (if an error occurred).
      // data.coords.latitude
      // data.coords.longitude
    });
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