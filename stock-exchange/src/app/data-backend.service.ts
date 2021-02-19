import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../environments/environment';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class DataBackendService {

  private getCelebrityEndpoint = environment.dataBackendUrl + '/get-celebrity/';
  private getCelebrityImageEndpoint = environment.dataBackendUrl + '/images/';

  constructor(private http: HttpClient) {
  }

  getCelebrity(id: string) {
    return this.http.get(this.getCelebrityEndpoint + id).pipe(
      map(this.extractData));
  }

  getCelebrityImage(id: string) {
    return this.getCelebrityImageEndpoint + id;
  }

  private extractData(res: Response) {
    const body = res;
    return body || {};
  }

}
