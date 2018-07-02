import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { Geolocation } from '@ionic-native/geolocation';

import { MyApp } from './app.component';
import { HomePage } from '../pages/home/home';


import { AgmCoreModule } from '@agm/core';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { RevealProvider } from '../providers/reveal/reveal';
import { EventsPage } from '../pages/events/events';
import { AgendaPage } from '../pages/agenda/agenda';



@NgModule({
  declarations: [
    MyApp,
    HomePage,
    EventsPage,
    AgendaPage
  ],
  imports: [
    BrowserModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyDPAFhOaeiQo7fum-pewjEAHT3E_ywQpEU'
    }),
    IonicModule.forRoot(MyApp),
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    HomePage,
    EventsPage,
    AgendaPage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    { provide: ErrorHandler, useClass: IonicErrorHandler },
    RevealProvider,
    Geolocation
  ]
})
export class AppModule { }
