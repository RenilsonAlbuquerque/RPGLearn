function generateRandomFace(sides: number): number{
    sides--;
    let result = Math.floor(Math.random() * sides);
    return result +1; 
}

export {generateRandomFace}