import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SurveyComponent } from './survey/survey.component';
import { LoginComponent } from './login/login.component';
import { ManagerSurveyComponent } from './manager-survey/manager-survey.component';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full'},
  { path: 'login', component: LoginComponent},
  { path: 'survey', component: SurveyComponent},
  { path: 'managersurvey', component: ManagerSurveyComponent},
  { path: '**', redirectTo: '/login'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
