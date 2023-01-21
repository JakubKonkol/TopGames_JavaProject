import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import { UsersComponent } from './users/users.component';
import {FormsModule} from "@angular/forms";
import { LogViewerComponent } from './log-viewer/log-viewer.component';
import { AppRoutingModule } from './app-routing.module';
import {RouterModule} from "@angular/router";


@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    LogViewerComponent
  ],
    imports: [
        BrowserModule,
        HttpClientModule, FormsModule, AppRoutingModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
