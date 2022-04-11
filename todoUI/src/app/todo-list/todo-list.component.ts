import { Component, OnInit } from '@angular/core';

import { Observable } from "rxjs";
import { TodoService } from "../todo.service";
import { Todo } from "../todo";
import { Router } from '@angular/router';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent implements OnInit {

  todoList: Todo[]=null;

  constructor(private todoService: TodoService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    console.log("at 25",this.todoList);
    this.todoService.getTodoList()
    .subscribe(data =>{this.todoList = data} , error => console.log(error));
    console.log("at 27",this.todoList);
  }

  deleteTodo(id: number) {
    console.log("id for delete",id);
    this.todoService.deleteTodo(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  todoDetails(id: number){
    console.log("id at 39 for details : ",id);
    this.router.navigate(['get-todo-by-id', id]);
  }

  updateTodo(id: number ){
    console.log("id at 39 for details : ",id);
    this.router.navigate(['update-todo', id]);
  }
}