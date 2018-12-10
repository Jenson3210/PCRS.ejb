import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { SurveyComponent } from './survey/survey.component';
import { SurveySectionComponent } from './survey-section/survey-section.component';
import { RatingComponent } from './rating/rating.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { SurveyOverviewComponent } from './survey-overview/survey-overview.component';
import { FormsModule } from '@angular/forms';
import { SurveyService } from './service/survey.service';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SurveyComponent,
    SurveySectionComponent,
    RatingComponent,
    SurveyOverviewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    NgbModule,
    HttpClientModule
  ],
  providers: [
    SurveyService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
