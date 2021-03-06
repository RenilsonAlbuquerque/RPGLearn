import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { environment } from 'src/environments/environment';
import { CharacterSheet } from 'src/app/domain/models/character/character.sheet';
import { CharacterCreateInput } from 'src/app/domain/models/character/character.create.input';
import { CharacterCreate } from 'src/app/domain/models/character/character.create';
import { CharacterInfo } from 'src/app/domain/models/character/character.info';
import  {BASE_URL} from '../../infra/config/constants';

@Injectable()
export class CharacterService {

    constructor(private httpClient: HttpClient) {
        
    }
    getCharacterSheet(characterId: number): Observable<CharacterSheet>{
        return this.httpClient.get<CharacterSheet>((`${BASE_URL}character/sheet/${characterId}`));
    }
    getCharacterSheetOnStory(storyId: number,userId: number): Observable<CharacterInfo>{
        return this.httpClient.post<CharacterInfo>(`${BASE_URL}character/user-story`,{userId:userId, storyId:storyId});
    }
    getCharacterCreationMetadata(): Observable<CharacterCreateInput>{
        return this.httpClient.get<CharacterCreateInput>(`${BASE_URL}character/metadata`);
    }
    createCharacterOfPlayerInStory(characterCreate: CharacterCreate):Observable<boolean>{
        return this.httpClient.post<boolean>(`${BASE_URL}character`,characterCreate);
    }

}