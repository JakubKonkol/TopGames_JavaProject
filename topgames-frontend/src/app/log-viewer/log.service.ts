import {Observable} from "rxjs";
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Log} from "./log";
@Injectable({
  providedIn: 'root'
})
export class LogService {
  private logUrl = 'http://localhost:8081/logs';
  constructor(private http: HttpClient) {
  }
  public getLogs(): Observable<Log[]> {
    return this.http.get<Log[]>(`${this.logUrl}/all`);
  }
  public getInfoLogs(): Observable<Log[]> {
    return this.http.get<Log[]>(`${this.logUrl}/info`);
  }
  public getErrorLogs(): Observable<Log[]> {
    return this.http.get<Log[]>(`${this.logUrl}/error`);
  }
  public getWarnLogs(): Observable<Log[]> {
    return this.http.get<Log[]>(`${this.logUrl}/warning`);
  }
  public getDebugLogs(): Observable<Log[]> {
    return this.http.get<Log[]>(`${this.logUrl}/debug`);
  }

}
