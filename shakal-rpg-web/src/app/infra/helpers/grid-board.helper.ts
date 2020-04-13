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
function createSvgWalk(squareDimension: number, speed: number):string{
  let result = 
  `<svg height="250" width="500">
    <g xmlns="http://www.w3.org/2000/svg">
      <rect id="svg_1" height="39" width="47" y="158.453125" x="101.5" stroke-width="1.5" stroke="#000" fill="#044B94" fill-opacity="0.4"/>
      <rect id="svg_2" height="39" width="47" y="158.453125" x="149.5" stroke-width="1.5" stroke="#000" fill="#044B94" fill-opacity="0.4"/>
      <rect id="svg_3" height="39" width="47" y="118.453125" x="149.5" stroke-width="1.5" stroke="#000" fill="#044B94" fill-opacity="0.4"/>
      <rect id="svg_4" height="39" width="47" y="197.453125" x="149.5" stroke-width="1.5" stroke="#000" fill="#044B94" fill-opacity="0.4"/>
      <rect id="svg_5" height="39" width="47" y="158.453125" x="196.5" stroke-width="1.5" stroke="#000" fill="#044B94" fill-opacity="0.4"/>
    </g>
  </svg>`;
  return result;

}
  function createSvgGrid(squareDimension: number,width:number, height:number):string{
    let result = `<svg #svgGrid  
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
   

export  {calculatePositionDrop,createSvgGrid};