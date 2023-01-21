import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import {LogViewerComponent} from "./log-viewer/log-viewer.component";
import {ActivatedRoute} from "@angular/router";


const routes: Routes = [
  { path: 'log-viewer', component: LogViewerComponent }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
