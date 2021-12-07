import { Router } from '@angular/router';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'angularFinal';

  constructor(private router: Router) {}

  logout() {
    sessionStorage.clear();
    this.router.navigate(['/home']);
  }

  get logged(): boolean {
    return !!sessionStorage.getItem('token') ? true : false;
  }
}
