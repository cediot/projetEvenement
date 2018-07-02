import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { Geolocation } from '@ionic-native/geolocation';



@Component({
  selector: 'page-home',
  templateUrl: 'home.html',

})
export class HomePage {

  title: string = 'My first AGM project';
  lat: number = 50.632035;
  lng: number =  3.059844;

  constructor(public navCtrl: NavController,private geolocation: Geolocation) {

    this.geolocation.getCurrentPosition().then((resp) => {
       this.lat=resp.coords.latitude
       this.lng=resp.coords.longitude
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
  
}