import { Component, OnInit } from '@angular/core';
import { Todo } from '../todo';
import { Router } from '@angular/router';
import { TodoService } from '../todo.service';


@Component({
  selector: 'app-create-todo',
  templateUrl: './create-todo.component.html',
  styleUrls: ['./create-todo.component.css']
})
export class CreateTodoComponent implements OnInit {

  todo: Todo = new Todo();
  submitted = false;
  

  constructor(private todoService: TodoService,
    private router: Router) { }

  ngOnInit() {

  }

  newTodo(): void {
    this.submitted = false;
    this.todo = new Todo();
  }

  save() {
    console.log("todo object at 28",this.todo);
    this.todoService.createTodo(this.todo)
      .subscribe(data =>{console.log("test at 30")} , error => console.log(error));
    //this.todo = new Todo();
    //Using Time out as angular is asyn and get-list is getting called before save/update is committed
    //posible solution : we can use global variable in service class(behavioural subject) or we can pass state variable using router-links
    setTimeout(() => {
      console.log('sleep');
      this.gotoList();
      // And any other code that should run only after 5s
    }, 1000);
    //this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {

    this.router.navigate(['/get-todo-listing']);
  }

}
