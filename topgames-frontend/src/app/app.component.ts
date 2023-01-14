import {Component, OnInit} from '@angular/core';
import {Game} from "./game";
import {GameService} from "./game.service";
import {User} from "./user";
import {UserService} from "./user.service";
import {HttpErrorResponse} from "@angular/common/http";
import {NgForm} from "@angular/forms";
import {Developer} from "./developer";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'topgames-frontend';
  public games: Game[] = [];
  public users: User[] = [];
  constructor(private gameService: GameService, private userService: UserService) { }
  ngOnInit() {
    this.getGames();
    this.getUsers();
  }
  public refreshPagePls(){
    window.location.reload();
  }
  public getGames(): void {
    this.gameService.getGames().subscribe(
      (response: Game[]) => {
        this.games = response;
      }
    );
  }
  public getUsers(): void {
    this.userService.getUsers().subscribe(
      (response: User[]) => {
        this.users = response;
      }
    );
  }
  public addGame(game: Game): void {
    this.gameService.addGame(game).subscribe(
      (response: Game) => {
        console.log(response);
        this.getGames();
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
  public addUserSamples(): void {
    this.userService.addSamples().subscribe(
      (response: void) => {
        console.log(response);
        this.getUsers();
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
  public removeUserSamples(): void {
    this.userService.removeAll().subscribe(
      (response: void) => {
        console.log(response);
        this.getUsers();
      }
    );
  }
  public openEditModal(game: Game): void {
  const modal = document.getElementById('modal'+game.id);
  // @ts-ignore
    modal.style.display = 'block';
  }
  public closeModal(game: Game): void {
    const modal = document.getElementById('modal'+game.id);
    // @ts-ignore
    modal.style.display = 'none';
  }
  public openAddUserModal():void{
    const modal = document.getElementById('createUserModal');
    // @ts-ignore
    modal.style.display = 'block';
  }
  public closeCreateGameModal(): void{
    const modal = document.getElementById('createGameModal');
    // @ts-ignore
    modal.style.display = 'none';
  }
  public createUser(form: NgForm): void{
  const user: User = {
    id: form.value.id,
    username: form.value.username,
    password: form.value.userpass,
    email: form.value.useremail,
    firstName: form.value.userfname,
    lastName: form.value.userlname
    }
    this.userService.addUser(user).subscribe(
      (response: User) => {
        console.log(response);
        this.getUsers();
      });
  }

}
