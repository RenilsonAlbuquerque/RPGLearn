import { CardPosition } from "src/app/domain/models/combat/card.position";
import { ElementRef } from '@angular/core';


 function calculatePositionDrop(x: number, y: number, zoomValue: number, squareDimension: number): CardPosition{
    let numberZoom: number = (zoomValue > 0)?  zoomValue: 1;
    x = x/numberZoom;
    y = y/numberZoom;
    
    let jump:number = numberZoom * squareDimension;
    let xResult:number = numberZoom * squareDimension;
    let yResult:number = numberZoom * squareDimension;
    for(var i = 0; i < x; i += jump){
        if(xResult >= x){
          if((xResult - x) >= jump/2.5){
            xResult -= jump; 
          }
          break;
        }else{
          xResult += jump;
        }
    }
    for(var j = 0; j < y; i += jump){
      if(yResult >= y){
        if((xResult - y) >= jump/2.5){
          yResult -= jump; 
        }
        break;
      }else{
        yResult += jump;
      }
    }
    console.log("y:" +y + ", Y: " + yResult);
    return {x:xResult, y:yResult};
}
function createSvgWalk(squareDimension: number, speed: number, position: CardPosition, creatureSize:number):string{
  console.log(creatureSize)
  //position = {x: position.x - (speed* squareDimension) + (creatureSize * squareDimension) ,y: position.y - (speed * squareDimension) + (creatureSize * squareDimension)};
  position = {x: position.x - (speed* squareDimension),y: position.y - (speed * squareDimension)};
  let valuesLog: string[] = [];
  let result = 
  `<g id="movePreview" xmlns="http://www.w3.org/2000/svg">`;
    let matrixDimension, c, k, space = 1;
    matrixDimension= speed + 1;
    space = matrixDimension - 1;
    console.log("space: " + space)
    let jumpX: number = position.x;
    let jumpY: number = position.y;
		  for (k = 1; k <= matrixDimension; k++)
		  {
		    for (c = 1; c <= space; c++){
          jumpY += squareDimension;
        }
		    space--;
		    for (c = 1; c <= (2*k-1); c++){
          valuesLog.push("x: "+ jumpX + " " + "y:" + jumpY);
          result += `<rect  height="${squareDimension}" width="${squareDimension}" y="${jumpY}" x="${jumpX}" stroke-width="1.5" stroke="#000" fill="#044B94" fill-opacity="0.4"/> \n`;
          jumpY += squareDimension;
        }
        jumpY = position.y;
        jumpX += squareDimension;
		  }
		  space = 1;
		  for (k = 1; k <= matrixDimension - 1; k++)
		  {
		    for (c = 1; c <= space; c++){
          jumpY += squareDimension;
        }
		    space++;
		    for (c = 1 ; c <= 2*(matrixDimension-k)-1; c++){
          valuesLog.push("x: "+ jumpX + " " + "y:" + jumpY);
          result += `<rect height="${squareDimension}" width="${squareDimension}" y="${jumpY}" x="${jumpX}" stroke-width="1.5" stroke="#000" fill="#044B94" fill-opacity="0.4"/> \n`;
          jumpY += squareDimension;
        }
        jumpY = position.y;
        jumpX += squareDimension;
      }
      console.log(valuesLog)
  result +=  `</g>`;
  return result;
}
function createSvgGrid(squareDimension: number,width:number, height:number):string{
    let result = `<svg id="svggrid" #svggrid  
     width="${width}" height="${height}" xmlns="http://www.w3.org/2000/svg">
      <defs> 
        <pattern id="smallGrid" width="${squareDimension}" height="${squareDimension}" patternUnits="userSpaceOnUse">
          <path d="M ${squareDimension} 0 L 0 0 0 ${squareDimension}" fill="none" stroke="gray" stroke-width="0.3"/>
        </pattern> 
        <pattern id="grid" width="${squareDimension}" height="${squareDimension}" patternUnits="userSpaceOnUse">
          <rect width="80" height="80" fill="url(#smallGrid)"/>
          <path d="M 80 0 L 0 0 0 80" fill="none" stroke="gray" stroke-width="1"/>
        </pattern>
      </defs>
      <rect width="100%" height="100%" fill="url(#grid)" />
    </svg>`;
      return result;
}
function deleteBatlePreview(dom: HTMLElement){
  document.getElementById("svg").removeChild
}
   

export  {calculatePositionDrop,createSvgGrid,createSvgWalk};