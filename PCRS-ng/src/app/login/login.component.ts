import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private email: string;
  private password: string;
  private error: string;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
  }

  login() {
    this.userService.getUser(this.email, this.password).subscribe(
      x => {
        this.userService.login(x.body[0]);
        this.router.navigate(['survey']);
      }, (error) => {
        switch (error.status) {
          case 403: {
              this.error = error.statusText;
            break;
          }
          default: {
            this.router.navigate(['login'], {
              queryParams: { error: 'unknown'}
            });
            break;
          }
        }
      }
    );
  }

}
