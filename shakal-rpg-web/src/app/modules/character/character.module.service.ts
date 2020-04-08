import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { environment } from 'src/environments/environment';
import { CharacterSheet } from 'src/app/domain/models/character/character.sheet';
import { CharacterCreateInput } from 'src/app/domain/models/character/character.create.input';

@Injectable()
export class CharacterService {

    constructor(private httpClient: HttpClient) {
        
    }
    getCharacterSheetOnStory(storyId: number,userId: number): Observable<CharacterSheet>{
        return this.httpClient.post<CharacterSheet>(`${environment.BASE_URL}character/user-story`,{userId:userId, storyId:storyId});
    }
    getCharacterCreationMetadata(): Observable<CharacterCreateInput>{
        return this.httpClient.get<CharacterCreateInput>(`${environment.BASE_URL}character/metadata`);
    }

}