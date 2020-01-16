import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'spring-angular-client';
  posts: any = [];

  constructor(private http: HttpClient) {
    http.get('http://localhost:8080/posts').subscribe(data => this.posts = data);
  }
}
