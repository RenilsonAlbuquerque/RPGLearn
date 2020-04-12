import { CardPosition } from "src/app/domain/models/combat/card.position";


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
    console.log("jump: " + jump)
    console.log("x:" +x + ", X: " + xResult);
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

export  {calculatePositionDrop};