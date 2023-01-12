import {Component, OnInit} from '@angular/core';
import {Game} from "./game";
import {GameService} from "./game.service";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'topgames-frontend';
  public games: Game[] = [];
  constructor(private gameService: GameService) { }
  ngOnInit() {
    this.getGames();
  }

  public getGames(): void {
    this.gameService.getGames().subscribe(
      (response: Game[]) => {
        this.games = response;
      }
    );
  }
  public deleteGame(gameId: number): void {
    this.gameService.deleteGame(gameId).subscribe(
      (response: void) => {
        console.log(response);
        this.getGames();
      }
    );
  }
  public addSamples(): void {
    this.gameService.addSamples().subscribe(
      (response: void) => {
        console.log(response);
        this.getGames();
      }
    );
  }
  public removeSamples(): void {
    this.gameService.removeSamples().subscribe(
      (response: void) => {
        console.log(response);
        this.getGames();
      }
    );
  }

}
