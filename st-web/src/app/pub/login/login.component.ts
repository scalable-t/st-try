import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/core/auth/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(
    public authService: AuthService
  ) { }

  public loading = false;

  ngOnInit(): void {
  }

  public onLogin(account: string, password: string) {
    this.loading = true;
    this.authService.login().subscribe(res => {
      this.loading = false;
    });
  }
}
