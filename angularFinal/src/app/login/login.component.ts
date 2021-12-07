import { Router } from '@angular/router';
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

  constructor(private authService: AuthService, private router: Router) {}

  ngOnInit(): void {}

  check() {
    this.authService.auth(this.login, this.password).subscribe(
      (ok) => {
        this.showMessage = false;
        sessionStorage.setItem('token', btoa(this.login + ':' + this.password));
        sessionStorage.setItem('login', this.login);
        if (!!ok['client']) {
          sessionStorage.setItem('role', 'user');
        } else {
          sessionStorage.setItem('role', 'admin');
        }
        this.router.navigate(['/home']);
      },
      (error) => {
        this.showMessage = true;
      }
    );
  }
}
