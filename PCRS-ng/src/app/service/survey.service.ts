import { Injectable } from '@angular/core';
import { SurveyKind } from '../model/survey-kind.enum';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IUser } from '../model/Interfaces/IUser';
import { ISurvey } from '../model/Interfaces/ISurvey';

@Injectable()
export class SurveyService {

  private baseUrl: String = 'PCRS-api/rest/v1/';

  constructor(private http: HttpClient) { }

  getSurveyForUser(user: IUser, surveyKind: SurveyKind): Observable<HttpResponse<ISurvey>> {
    return this.http.get<ISurvey>(this.baseUrl + 'usersurveys/' + user.id, {
      params: {
        surveyKind : SurveyKind[surveyKind]
      },
      observe: 'response'
    });
  }

  save(survey: ISurvey) {
    // TODO
  }
}
