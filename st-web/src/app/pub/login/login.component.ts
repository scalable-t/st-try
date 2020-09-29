import { Component, OnInit } from '@angular/core';
<<<<<<< HEAD
import { AuthService } from 'src/app/core/auth/auth.service';
=======
>>>>>>> 11cf9df0a2440ebc8ff4178764bbcec158436da0

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

<<<<<<< HEAD
  constructor(
    public authService: AuthService
  ) { }

  public loading = false;
=======
  constructor() { }
>>>>>>> 11cf9df0a2440ebc8ff4178764bbcec158436da0

  ngOnInit(): void {
  }

<<<<<<< HEAD
  public onLogin(account: string, password: string) {
    this.loading = true;
    this.authService.login().subscribe(res => {
      this.loading = false;
    });
  }
=======
>>>>>>> 11cf9df0a2440ebc8ff4178764bbcec158436da0
}
