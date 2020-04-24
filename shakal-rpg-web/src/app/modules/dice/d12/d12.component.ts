import { Component, OnInit } from '@angular/core';
import { DiceService } from '../dice.module.service';
import { generateRandomId } from 'src/app/infra/helpers/grid-board.helper';
import { generateRandomFace } from 'src/app/infra/helpers/dice.helper';
import { DiceComponent } from 'src/app/domain/models/dice/dice.component';

@Component({
  selector: 'app-d12',
  templateUrl: './d12.component.html',
  styleUrls: ['./d12.component.scss']
})
export class D12Component implements OnInit, DiceComponent {

  private selfId: string;
  private die: HTMLElement;
  private sides: number;
  private initialSide: number;
  private lastFace: number;
  private timeoutId;
  private transitionDuration: number;
  private animationDuration: number;
  public prefixedResult: number;
  constructor(private diceService: DiceService){
    this.selfId = generateRandomId();
    this.sides = 12;
    this.initialSide = 1;
    this.transitionDuration = 500;
    this.animationDuration = 3000;
    
    
  }
  ngOnInit(){
    this.die = document.getElementById(this.selfId);
  }
  public roll(){
    this.die = document.getElementById(this.selfId);
    this.die.classList.add('rolling')
    clearTimeout(this.timeoutId)
    let result = 0;
    if(this.prefixedResult > 0){
      result = this.prefixedResult;
    }
    else{
      result = generateRandomFace(12);
    }
    this.timeoutId = setTimeout(() => {
      this.rollTo(result)
    })
    return result ; 
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
