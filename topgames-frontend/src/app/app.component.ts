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

}
