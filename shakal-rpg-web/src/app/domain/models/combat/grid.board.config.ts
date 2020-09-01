import { ElementRef } from '@angular/core';

export interface GridBoardConfig{

  canvas: ElementRef<HTMLCanvasElement>;
  mainContainer: ElementRef<HTMLCanvasElement>;
  imageContainer: ElementRef<HTMLCanvasElement>;
  svgBattleGrid: HTMLElement;
  image:any;


}