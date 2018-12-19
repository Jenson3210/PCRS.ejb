import { Injectable } from '@angular/core';
import { IUser } from '../model/Interfaces/IUser';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ISurveySet } from '../model/Interfaces/ISurveySet';
import { IPrivilege } from '../model/Interfaces/IPrivilege';
import { PrivilegeType } from '../model/PrivilegeType.enum';

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
  getSurveySets(): ISurveySet[] {
    const surveySets: ISurveySet[] = [];
    console.log(this.user);
    for (const privilege of this.user.privileges) {
      if (privilege.privilegeType as PrivilegeType === PrivilegeType.TEAMMEMBER) {
        for (const surveySet of privilege.surveySetTreeSet) {
          surveySets.push(surveySet);
        }
      }
    }
    return surveySets;
  }
  getUserById(userId: string): Observable<HttpResponse<IUser[]>> {
    return this.http.get<IUser[]>(this.baseUrl + 'users', {
      params: {
        id: userId
      },
      observe: 'response'
    });
  }
}
