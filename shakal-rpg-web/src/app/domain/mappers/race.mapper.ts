import { RaceCreateInput } from '../models/race/race.create.input';

export default function initializeRaceInputDetails():RaceCreateInput{
    return {
        speed: 0,
        alignmentDescription:"",
        atributeBonus:[],
        ageDescription: "",
        sizeDescription: ""
    } as RaceCreateInput;
}