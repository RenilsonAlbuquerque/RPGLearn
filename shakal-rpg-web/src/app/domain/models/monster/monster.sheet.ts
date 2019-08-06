import { Atribute } from '../comon/atribute';
import { SavingThrow } from '../comon/saving-throw';
import { NameDescription } from '../comon/name-description';
import { AttackDto } from '../comon/attack-dto';

export interface MonsterSheet{
    id: number,
    name: String,
    alignment: string,
    size: string,
    armorClass: number,
    lifePoints: number,
    challengeLevel: String,
    atributes: Atribute[],
    savingThrows: SavingThrow[],
    damageResistence: String[],
    damageImunity: String[],
    languages: String[],
    features: NameDescription[],
    actions: AttackDto[],
    legendaryActions: AttackDto[]
}