import { Observable} from "rxjs";
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Game} from "./game";
@Injectable({
  providedIn: 'root'
})
export class GameService {
  private gameUrl = 'http://localhost:8080/api/game';
  constructor(private http: HttpClient) { }

  public getGames(): Observable<Game[]> {
    return this.http.get<Game[]>(`${this.gameUrl}/getAll`);
  }
  public addGame(game: Game): Observable<Game> {
    return this.http.post<Game>(`${this.gameUrl}/add`, game);
  }
  public deleteGame(gameId: number): Observable<void> {
    return this.http.delete<void>(`${this.gameUrl}/delete/${gameId}`);
  }
  public addSamples(): Observable<void> {
    return this.http.post<void>(`${this.gameUrl}/dev/addSamples`, null);
  }
  public removeSamples(): Observable<void> {
    return this.http.post<void>(`${this.gameUrl}/dev/deleteAll`, null);
  }
}
