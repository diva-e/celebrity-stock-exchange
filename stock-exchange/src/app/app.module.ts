import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { CelebrityDetailComponent } from './celebrity-detail/celebrity-detail.component';
import {RouterModule, Routes} from '@angular/router';


const appRoutes: Routes = [
  {path: 'celebrity/:id', component: CelebrityDetailComponent},
  {path: '', redirectTo: '/celebrity/foo-notavailable', pathMatch: 'full'},
  {path: 'not-found', component: PageNotFoundComponent},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    PageNotFoundComponent,
    CelebrityDetailComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
