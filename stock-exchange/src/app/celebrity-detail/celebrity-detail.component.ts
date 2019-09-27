import { Component, OnInit } from '@angular/core';
import {DataBackendService} from '../data-backend.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-celebrity-detail',
  templateUrl: './celebrity-detail.component.html',
  styleUrls: ['./celebrity-detail.component.css']
})
export class CelebrityDetailComponent implements OnInit {

  celebrity;

  constructor(
    private backendService: DataBackendService,
    private route: ActivatedRoute,
    private router: Router) {
  }

  ngOnInit() {
    let celebrityId: string;

    celebrityId = this.route.snapshot.params.id;

    const celebObservable = this.backendService.getCelebrity(celebrityId);

    celebObservable.subscribe(
      (body: any) => this.celebrity = body,
      () => this.router.navigateByUrl('/not-found' , { skipLocationChange: true })
    );

  }

}
