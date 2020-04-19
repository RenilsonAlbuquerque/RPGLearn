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
    return {x:xResult, y:yResult};
}
function createSvgWalk(squareDimension: number, speed: number, position: CardPosition, creatureSize:number):string{
  let squareColor = "#044B94";
  position = adjustPosition(position,squareDimension)
  if(creatureSize <= 1){
    position = {x: position.x - (speed* squareDimension),y: position.y - (speed * squareDimension)};
    
  }else{
    if(creatureSize = 2){
      position = {x: position.x - (speed* squareDimension) + (1 * squareDimension) ,y: position.y - (speed * squareDimension) + (creatureSize/2 * squareDimension)};
    }
    if(creatureSize == 3){
      position = {x: position.x - (speed* squareDimension) + (1 * squareDimension) ,y: position.y - (speed * squareDimension) + (2 * squareDimension)};
    }
    if(creatureSize == 4){
      position = {x: position.x - (speed* squareDimension) + (2 * squareDimension) ,y: position.y - (speed * squareDimension) + (2 * squareDimension)};
    }
  }
  
  
  //position = {x: position.x - (speed* squareDimension),y: position.y - (speed * squareDimension)};
  let result = 
  `<g id="movePreview" xmlns="http://www.w3.org/2000/svg">`;
    let matrixDimension, c, k, space = 1;
    matrixDimension= speed + 1;
    space = matrixDimension - 1;
    let jumpX: number = position.x;
    let jumpY: number = position.y;
		  for (k = 1; k <= matrixDimension; k++)
		  {
		    for (c = 1; c <= space; c++){
          jumpY += squareDimension;
        }
		    space--;
		    for (c = 1; c <= (2*k-1); c++){
          result += `<rect  height="${squareDimension}" width="${squareDimension}" y="${jumpY}" x="${jumpX}" stroke-width="1.5" stroke="#000" fill="${squareColor}" fill-opacity="0.4"/> \n`;
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
          result += `<rect height="${squareDimension}" width="${squareDimension}" y="${jumpY}" x="${jumpX}" stroke-width="1.5" stroke="#000" fill="${squareColor}" fill-opacity="0.4"/> \n`;
          jumpY += squareDimension;
        }
        jumpY = position.y;
        jumpX += squareDimension;
      }
  result +=  `</g>`;
  return result;
}
function createSvgDoubleMove(squareDimension: number, speed: number, position: CardPosition, creatureSize:number):string{
  let squareColor = "#C82333";
  position = adjustPosition(position,squareDimension)
  if(creatureSize <= 1){
    position = {x: position.x - (speed* squareDimension *2),y: position.y - (speed * squareDimension *2)};
  }else{
    if(creatureSize = 2){
      position = {x: position.x - (speed* squareDimension  *2) + (1 * squareDimension) ,y: position.y - (speed * squareDimension *2) + (creatureSize/2 * squareDimension)};
    }
    if(creatureSize == 3){
      position = {x: position.x - (speed* squareDimension *2) + (1 * squareDimension) ,y: position.y - (speed * squareDimension *2 ) + (2 * squareDimension)};
    }
    if(creatureSize == 4){
      position = {x: position.x - (speed* squareDimension) + (2 * squareDimension) ,y: position.y - (speed * squareDimension *2) + (2 * squareDimension)};
    }
  }
  
  
  //position = {x: position.x - (speed* squareDimension),y: position.y - (speed * squareDimension)};
  let result = 
  `<g id="doubleMovePreview" xmlns="http://www.w3.org/2000/svg">`;
    let matrixDimension, c, k, space = 1;
    matrixDimension= (speed *2)+ 1;
    space = matrixDimension - 1;
    let jumpX: number = position.x;
    let jumpY: number = position.y;
		  for (k = 1; k <= matrixDimension; k++)
		  {
		    for (c = 1; c <= space; c++){
          jumpY += squareDimension;
        }
		    space--;
		    for (c = 1; c <= (2*k-1); c++){
          result += `<rect  height="${squareDimension}" width="${squareDimension}" y="${jumpY}" x="${jumpX}" stroke-width="1.5" stroke="#000" fill="${squareColor}" fill-opacity="0.4"/> \n`;
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
          result += `<rect height="${squareDimension}" width="${squareDimension}" y="${jumpY}" x="${jumpX}" stroke-width="1.5" stroke="#000" fill="${squareColor}" fill-opacity="0.4"/> \n`;
          jumpY += squareDimension;
        }
        jumpY = position.y;
        jumpX += squareDimension;
      }
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
function generateRandomId(): string{
  return 'xxxxxxxxxxxx4xxxyxxxxxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
    var r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
    return v.toString(16);
  }); 
}
function moveCreature(elemento:HTMLElement, position: CardPosition):void{
  let calculatedPosition = adjustPosition(position,30);
  elemento.style.top = calculatedPosition.y.toString() + "px";
  elemento.style.left = calculatedPosition.x.toString() + "px";
}
function adjustPosition(position:CardPosition, squareDimension: number):CardPosition{
  return  {
    x:Math.floor(position.x/squareDimension) * squareDimension,
    y: Math.floor(position.y/squareDimension) * squareDimension
  }

}
   

export  {calculatePositionDrop,createSvgGrid,createSvgWalk,generateRandomId,moveCreature,createSvgDoubleMove,adjustPosition};