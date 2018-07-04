import { Component } from '@angular/core';


@Component({
  selector: 'event-details',
  templateUrl: 'event-details.html'
})
export class EventDetailsComponent {

  text: string;

  constructor() {
    console.log('Hello EventDetailsComponent Component');
    this.text = 'Hello World';
  }

}
