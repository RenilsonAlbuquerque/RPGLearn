import { Component, OnInit } from '@angular/core';
import { DiceService } from '../dice.module.service';
import { generateRandomId } from 'src/app/infra/helpers/grid-board.helper';
import { generateRandomFace } from 'src/app/infra/helpers/dice.helper';

@Component({
  selector: 'app-d12',
  templateUrl: './d12.component.html',
  styleUrls: ['./d12.component.scss']
})
export class D12Component implements OnInit {

  private selfId: string;
  private die: HTMLElement;
  private sides: number;
  private initialSide: number;
  private lastFace: number;
  private timeoutId;
  private transitionDuration: number;
  private animationDuration: number;
  constructor(private diceService: DiceService){
    this.selfId = generateRandomId();
    this.sides = 12;
    this.initialSide = 1;
    this.transitionDuration = 500;
    this.animationDuration = 3000;
    this.diceService.addDiceCOmponentToRoll(this);
    
  }
  ngOnInit(){
    this.die = document.getElementById(this.selfId);
  }
  public roll(){
    this.die = document.getElementById(this.selfId);
    this.die.classList.add('rolling')
    clearTimeout(this.timeoutId)
  
    this.timeoutId = setTimeout(() => {
      this.rollTo(generateRandomFace(12))
    })
    return false ; 
  }
  rollTo(face: number) {
    //clearTimeout(this.timeoutId)
    this.die.classList.toggle("roll-1");
    this.die.classList.toggle("roll-2");
    this.die.dataset.roll = face.toString();
  }
  randomFace(): number {
    var face = Math.floor((Math.random() * this.sides)) + this.initialSide
    this.lastFace = face == this.lastFace ? this.randomFace() : face
    return face;
  }


}
