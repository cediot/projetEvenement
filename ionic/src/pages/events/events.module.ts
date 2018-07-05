import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { EventsPage } from './events';
import { SchedulePage } from '../schedule/schedule';


@NgModule({
  declarations: [
    EventsPage,
    SchedulePage
  ],
  imports: [
    IonicPageModule.forChild(EventsPage),
  ],
})
export class EventsPageModule {}
