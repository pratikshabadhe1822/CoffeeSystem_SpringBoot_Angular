import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: false,  // Not a standalone component
  styleUrls: ['./app.component.css']  // Corrected to styleUrls
})
export class AppComponent {
  title = 'coffee-system';
}
