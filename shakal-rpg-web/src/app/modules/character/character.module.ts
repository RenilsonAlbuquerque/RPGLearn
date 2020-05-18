import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CharacterCreateComponent } from './character-create/character-create.component';
import { CharacterRoutingModule } from './character.module.routing';
import { MaterialModule } from '../material-design/material.module';
import { CharacterService } from './character.module.service';
import { FormBuilder, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CharacterSheetComponent } from './character-sheet/character-sheet.component';
import { RaceService } from 'src/app/infra/services/race.service';
import { ClassService } from 'src/app/infra/services/class.service';
import { CharacterAtributesPieceComponent } from './character-sheet/character-atributes-piece/character-atributes-piece.component';
import { CharacterLifePieceComponent } from './character-sheet/character-life-piece/character-life-piece.component';
import { library } from '@fortawesome/fontawesome-svg-core';
import { faShieldAlt, faHandSparkles, faMagic, faFingerprint, faGem } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { CharacterItemPieceComponent } from './character-sheet/character-item-piece/character-item-piece.component';
import { CoinModule } from '../coin/coin.module';
import { CharacterTraitsPieceComponent } from './character-sheet/character-traits-piece/character-traits-piece.component';
import { CharacterSpellsPieceComponent } from './character-sheet/character-spells-piece/character-spells-piece.component';
//import { DirectivesModule } from '../generalmodules/directives.module';




@NgModule({
  declarations: [CharacterCreateComponent, CharacterSheetComponent, CharacterAtributesPieceComponent, CharacterLifePieceComponent, CharacterItemPieceComponent, CharacterTraitsPieceComponent, CharacterSpellsPieceComponent],
  imports: [
    CommonModule,
    CharacterRoutingModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    FontAwesomeModule,
    CoinModule
    //DirectivesModule
  ],
  providers:[CharacterService,FormBuilder,RaceService,ClassService],
  exports: [CharacterSheetComponent]
})
export class CharacterModule { 
  constructor(){
    library.add(faShieldAlt,faHandSparkles,faMagic,faFingerprint,faGem);
  }
}
