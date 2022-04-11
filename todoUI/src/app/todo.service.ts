import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  private baseUrl = 'http://localhost:8081/myapp';
  private getTodoUrl = 'get-todo-by-id';
  private getTodoListUrl = 'get-todo-listing';
  private saveTodoUrl = 'save-todo';
  private updateTodoUrl = 'update-todo';
  private deleteTodoUrl = 'delete-todo';

  constructor(private http: HttpClient) { }
  getTodo(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${this.getTodoUrl}/${id}`);
  }

  createTodo(todo: Object): Observable<Object> {
    console.log("todo at service : ",todo);
    return this.http.post(`${this.baseUrl}/${this.saveTodoUrl}`, todo);
  }

  updateTodo(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${this.updateTodoUrl}/${id}`, value);
  }

  deleteTodo(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${this.deleteTodoUrl}/${id}`, { responseType: 'text' });
  }

  getTodoList(): Observable<any> {
    console.log(this.baseUrl+"/"+this.getTodoListUrl);
    return this.http.get(`${this.baseUrl}/${this.getTodoListUrl}`);
  }
}