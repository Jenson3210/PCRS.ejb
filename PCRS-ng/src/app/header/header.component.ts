import { Component, OnInit } from '@angular/core';
import { IUser } from '../model/Interfaces/IUser';
import { ISurveySet } from '../model/Interfaces/ISurveySet';
import { Router } from '@angular/router';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public user = {} as IUser;
  public surveySets: ISurveySet[] = [];

  constructor(
    private userService: UserService,
    private router: Router) { }

  ngOnInit() { }
  logoff() {
    this.userService.logoff();
    this.router.navigate(['login']);

  }
  loggedIn() {
    let loggedIn = false;
    if (this.userService.user != null) {
      loggedIn = true;
    }
    return loggedIn;
  }
  getSurveySets() {
    return this.userService.getSurveySets();
  }
  getUser(): IUser {
    return this.userService.user;
  }
}
