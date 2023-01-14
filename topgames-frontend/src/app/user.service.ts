import { Observable} from "rxjs";
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {User} from "./user";
@Injectable({
  providedIn: 'root'
})
export class UserService {
  private userUrl = 'http://localhost:8080/api/user';
  constructor(private http: HttpClient) { }

  public getUsers(): Observable<User[]> {
    return this.http.get<User[]>(`${this.userUrl}/getAll`);
  }
  public addUser(user: User): Observable<User> {
    return this.http.post<User>(`${this.userUrl}/add`, user);
  }
  public deleteUser(userId: number): Observable<void> {
    return this.http.delete<void>(`${this.userUrl}/delete/${userId}`);
  }
  public addSamples(): Observable<void> {
    return this.http.post<void>(`${this.userUrl}/dev/addSamples`, null);
  }
  public removeAll(): Observable<void> {
    return this.http.post<void>(`${this.userUrl}/dev/deleteAll`, null);
  }
}
