import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';
import { IAlert } from '../model/Interfaces/IAlert';
import { AlertType } from '../model/alert-type.enum';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private email: string;
  private password: string;
  private errors: IAlert[];

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() { }

  login() {
    this.errors = [];
    this.userService.getUser(this.email, this.password).subscribe(
      x => {
        this.userService.login(x.body);
        this.router.navigate(['survey']);
      }, (error) => {
        switch (error.status) {
          case 403: {
              this.errors.push({message: error.statusText, type: AlertType.DANGER});
            break;
          }
          default: {
            this.errors.push({message: error.statusText, type: AlertType.DANGER});
            break;
          }
        }
      }
    );
  }

}
