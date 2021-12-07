import { AuthService } from './../services/auth.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  login: string = '';
  password: string = '';
  showMessage = false;

  constructor(private authService: AuthService) {}

  ngOnInit(): void {}

  check() {
    this.authService.auth(this.login, this.password).subscribe(
      (ok) => {
        this.showMessage = false;
      },
      (error) => {
        this.showMessage = true;
      }
    );
  }
}
