import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { Geolocation } from '@ionic-native/geolocation';
import { Calendar } from '@ionic-native/calendar';
import { HttpModule } from '@angular/http';

import { MyApp } from './app.component';
import { HomePage } from '../pages/home/home';
import { AjouterPage } from '../pages/ajouter/ajouter';


import { AgmCoreModule, GoogleMapsAPIWrapper } from '@agm/core';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { RevealProvider } from '../providers/reveal/reveal';
import { EventsPage } from '../pages/events/events';
import { AgendaPage } from '../pages/agenda/agenda';
import { SchedulePage } from '../pages/schedule/schedule';
import { CalendarComponent } from '../components/calendar/calendar';

import { CalendarModule } from 'angular-calendar';
import { RecherchePage } from '../pages/recherche/recherche';
import { SettingsPage } from '../pages/settings/settings';
import { ListEventProvider } from '../providers/list-event/list-event';
import { EventDetailsProvider } from '../providers/event-details/event-details';
import { ConnectivityServiceProvider } from '../providers/connectivity-service/connectivity-service';
// angular fire
import { AngularFireModule } from 'angularfire2';
import { AngularFirestoreModule } from 'angularfire2/firestore';

export const firebaseConfig = {
  apiKey: "AIzaSyBoT9K1AOKCx6ajIyYr0DtK3dwDvwFCTlo",
  authDomain: "event-727d4.firebaseapp.com",
  databaseURL: "https://event-727d4.firebaseio.com",
  projectId: "event-727d4",
  storageBucket: "event-727d4.appspot.com",
  messagingSenderId: "259772268143"
};

@NgModule({
  declarations: [
    MyApp,
    HomePage,
    EventsPage,
    AgendaPage,
    SchedulePage,
    CalendarComponent,
    AjouterPage,
    RecherchePage,
    SettingsPage

  ],
  imports: [
    HttpModule,
    BrowserModule,
    BrowserAnimationsModule,
    CalendarModule.forRoot(),
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyDPAFhOaeiQo7fum-pewjEAHT3E_ywQpEU'
    }),
    IonicModule.forRoot(MyApp),
    AngularFireModule.initializeApp(firebaseConfig),
    AngularFirestoreModule.enablePersistence()
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    HomePage,
    EventsPage,
    AgendaPage,
    SchedulePage,
    AjouterPage,
    RecherchePage,
    SettingsPage,


  ],
  providers: [
    StatusBar,
    SplashScreen,
    { provide: ErrorHandler, useClass: IonicErrorHandler },
    RevealProvider,
    Geolocation,
    Calendar,
    ListEventProvider,
    EventDetailsProvider,
    ConnectivityServiceProvider,
    GoogleMapsAPIWrapper
  ]
})
export class AppModule { }
