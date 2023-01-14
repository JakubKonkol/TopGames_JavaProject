import {Developer} from "./developer";

export interface Game{
    id: number;
    name: string;
    description: string;
    genre: string;
    developer: Developer;
    releaseDate: string;
    platform: string;
}
