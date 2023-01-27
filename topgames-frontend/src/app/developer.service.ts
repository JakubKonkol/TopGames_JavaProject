import {Observable} from "rxjs";
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Developer} from "./developer";
@Injectable({
  providedIn: 'root'
})
export class DeveloperService {
  private developerUrl = 'http://localhost:8081/api/developer';
  constructor(private http: HttpClient) { }
  public getDevelopers(): Observable<Developer[]> {
    return this.http.get<Developer[]>(`${this.developerUrl}/getAll`);
  }

}
