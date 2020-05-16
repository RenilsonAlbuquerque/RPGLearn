export interface CharacterCreate{
    userId: number,
    storyId: number,
    imagePath: string,
    tokenImageRaw: string,
    name: string,
    publicBackground: string,
    secretBackground: string,

    strength:number,
    dexterity: number,
    constitution: number,
    inteligence: number,
    wisdom: number,
    charisma: number,
    
    proeficiencies:number[],
    
    age: number,
    weight: number,
    height:number,
    alignment: number,
    classs: number,
    race: number,
}