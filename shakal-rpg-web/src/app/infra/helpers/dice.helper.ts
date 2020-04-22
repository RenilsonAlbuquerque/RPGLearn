function generateRandomFace(sides: number): number{
    sides--;
    let result = Math.floor(Math.random() * sides);
    console.log(result + 1);
    return result +1; 
}

export {generateRandomFace}