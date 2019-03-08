import { Component } from '@angular/core';
import { DataBackendService } from "./data-backend.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  celebrity;

  constructor(private backendService: DataBackendService) {
  }

  ngOnInit() {
    var celbObservable = this.backendService.getCelebrity();

    celbObservable.subscribe(
      (body : any) => this.celebrity = body,//console.log('body'),
      (res : any) => console.log('res'),
      () => console.log('done!')
    );

  }
}
