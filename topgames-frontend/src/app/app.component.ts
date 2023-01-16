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
        this.ngOnInit();
        this.getGames();
      }
    );
  }
  public deleteUser(userId: number):void{
    this.userService.deleteUser(userId).subscribe(
      (response:void) => {
        console.log(response)
        this.getUsers();
      }
    )
  }
  public addSamples(): void {
    this.gameService.addSamples().subscribe(
      (response: void) => {
        console.log(response);
        this.ngOnInit();
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
  public openEditModal(user: User): void {
  const modal = document.getElementById('modal'+user.id);
  // @ts-ignore
    modal.style.display = 'block';
  }
  public closeModal(user: User): void {
    const modal = document.getElementById('modal'+user.id);
    // @ts-ignore
    modal.style.display = 'none';
  }
  public openAddUserModal():void{
    const modal = document.getElementById('createUserModal');
    // @ts-ignore
    modal.style.display = 'block';
  }
  public closeCreateGameModal(): void{
    const modal = document.getElementById('createUserModal');
    // @ts-ignore
    modal.style.display = 'none';
  }
  public createUser(form: NgForm): void{
    this.userService.addUser(form.value).subscribe(
      (response: User) => {
        console.log(form.value);
        console.log(response);
        this.closeCreateGameModal();
        this.getUsers();
        form.reset();
      }
    );
  }
  public editUserById(userId: number, form: NgForm): void{
    this.userService.editUser(userId, form.value).subscribe(
      (response: User) => {
        console.log(response);
        this.getUsers();
      }
    );
  }

}
