import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Page } from 'src/app/infra/models/page';
import { StoryOverview } from 'src/app/domain/models/story/story-overview';
import { environment } from 'src/environments/environment';
import { StoryDetail } from 'src/app/domain/models/story/story-detail';
import { PlaceDetail } from 'src/app/domain/models/story/place-detail';
import { StoryCreateInput } from 'src/app/domain/models/story/story-create-input';
import { StoryCreate } from 'src/app/domain/models/story/story-create';

@Injectable()
export class StoryService {

    constructor(private httpClient: HttpClient) {
        
    }
    getOverview(pageNumber): Observable<Page<StoryOverview>>{
        return this.httpClient.post<Page<StoryOverview>>(`${environment.BASE_URL}story/list`,{page:pageNumber, size:9});
    }
    getSearchResult(searchString: String, pageNumber): Observable<Page<StoryOverview>>{
        return this.httpClient.post<Page<StoryOverview>>(`${environment.BASE_URL}monster/filter?name=${searchString}`,{page:pageNumber, size:9});
    }
    createStory(story: StoryCreate): Observable<StoryCreate>{
        return this.httpClient.post<StoryCreate>(`${environment.BASE_URL}story`,story);
    }
    getStoryInfoById(id): Observable<StoryDetail>{
        return this.httpClient.get<StoryDetail>(`${environment.BASE_URL}story/info/${id}`);
    }
    getStoryCreateInput(): Observable<StoryCreateInput>{
        return this.httpClient.get<StoryCreateInput>(`${environment.BASE_URL}story/input`);
    }
    getPlaceInfoById(id): Observable<PlaceDetail>{
        return this.httpClient.get<PlaceDetail>(`${environment.BASE_URL}place/info/${id}`);
    }
}