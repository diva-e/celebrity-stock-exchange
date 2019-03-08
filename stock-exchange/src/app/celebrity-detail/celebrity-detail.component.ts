import { Component, OnInit } from '@angular/core';
import {DataBackendService} from "../data-backend.service";

@Component({
  selector: 'app-celebrity-detail',
  templateUrl: './celebrity-detail.component.html',
  styleUrls: ['./celebrity-detail.component.css']
})
export class CelebrityDetailComponent implements OnInit {

  celebrity;

  constructor(private backendService: DataBackendService) {
  }

  ngOnInit() {
    var celbObservable = this.backendService.getCelebrity();

    celbObservable.subscribe(
      (body: any) => this.celebrity = body,//console.log('body'),
      (res: any) => console.log('res'),
      () => console.log('done!')
    );

  }

}
