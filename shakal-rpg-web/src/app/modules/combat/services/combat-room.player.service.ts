import { Injectable } from '@angular/core';
import { CombatRoomService } from './combat-room.service';
import { HttpClient } from '@angular/common/http';
import {  RxStompService } from "@stomp/ng2-stompjs";
import { CharacterInfo } from 'src/app/domain/models/character/character.info';
import { CombatState } from 'src/app/domain/models/combat/combat.state';

@Injectable()
export class CombatRoomPlayerService extends CombatRoomService{

    private characterInfo: CharacterInfo;
    constructor(protected httpClient: HttpClient,protected rxStompService: RxStompService){
        super(httpClient,rxStompService)
        
    }
    public getCurrentCharacterInfo(): CharacterInfo{
        return this.characterInfo;
    }
    public setCurrentCharacterInfo(characterInfo: CharacterInfo): void{
        this.characterInfo = characterInfo;
        
    }
    public initializePlayerInfo(characterInfo: CharacterInfo, playerId: number){
        var combatState: CombatState = this.combatState.getValue();
        var alreadyOn : boolean = false;
        combatState.creatures.forEach((creature) =>{
            if(creature.id == characterInfo.characterToken.id && creature.playerId == playerId ){
                alreadyOn = true;
            }
        })
        if(!alreadyOn){
            combatState.creatures.push(characterInfo.characterToken);
            this.onSendMessage(combatState);
        }
    }
}