import { NgModule } from '@angular/core';
import { CalendarComponent } from './calendar/calendar';
import { EventDetailsComponent } from './event-details/event-details';

@NgModule({
	declarations: [CalendarComponent,
    EventDetailsComponent
   ],
	imports: [],
	exports: [CalendarComponent,
    EventDetailsComponent
 ]
})
export class ComponentsModule {}
