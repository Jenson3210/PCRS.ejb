import { Injectable } from '@angular/core';
import { IUser } from '../model/Interfaces/IUser';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  public user: IUser;
  private baseUrl: String = 'PCRS-api/rest/v1/';

  constructor(private http: HttpClient) { }

  logoff() {
    this.user = null;
    return true;
  }
  getUser(email: string, password: string): Observable<HttpResponse<IUser[]>> {
    return this.http.get<IUser[]>(this.baseUrl + 'users', {
      params: {
        email : email,
        password: password
      },
      observe: 'response'
    });
  }
  login(user: IUser): boolean {
    this.user = user;
    return true;
  }
}
