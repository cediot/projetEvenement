import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { Geolocation } from '@ionic-native/geolocation';
import { Calendar } from '@ionic-native/calendar';

import { MyApp } from './app.component';
import { HomePage } from '../pages/home/home';
import { AjouterPage } from '../pages/ajouter/ajouter';


import { AgmCoreModule } from '@agm/core';
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
import { EventDetailsComponent } from '../components/event-details/event-details';


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
    BrowserModule,
    BrowserAnimationsModule,
    CalendarModule.forRoot(),
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
    AgendaPage,
    SchedulePage,
    AjouterPage,
    RecherchePage,
    SettingsPage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    { provide: ErrorHandler, useClass: IonicErrorHandler },
    RevealProvider,
    Geolocation,
    Calendar,
    EventDetailsComponent
  ]
})
export class AppModule { }
