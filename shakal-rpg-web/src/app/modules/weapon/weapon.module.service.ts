import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { WeaponInfo } from 'src/app/domain/models/weapon/weapon.info';
import { environment } from 'src/environments/environment';



@Injectable()
export class WeaponModuleService {
    constructor(private httpClient: HttpClient){
        
    }
    getWeaponDetail(weaponId: number): Observable<WeaponInfo>{
        return this.httpClient.get<WeaponInfo>((`${environment.BASE_URL}weapon/detail/${weaponId}`));
    }
}