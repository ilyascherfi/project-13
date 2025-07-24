import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class ChatService {
  private apiUrl = 'http://localhost:8080/api/chat'; // URL du backend

  private http = inject(HttpClient);

  newChat(fullName: string): Observable<string> {
    return this.http.post<string>(`${this.apiUrl}/start`, fullName);
  }

}
