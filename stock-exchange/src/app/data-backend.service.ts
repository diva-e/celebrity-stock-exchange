import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {environment} from "../environments/environment";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class DataBackendService {

  private getCelebrityEndpoint = environment.dataBackendUrl + '/get-celebrity/';

  constructor(private http: HttpClient) {
  }

  getCelebrity(id: string) {
    return this.http.get(this.getCelebrityEndpoint + id).pipe(
      map(this.extractData));
  }

  private extractData(res: Response) {
    let body = res;
    return body || {};
  }

}
