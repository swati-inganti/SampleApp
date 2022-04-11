import { Component, OnInit } from '@angular/core';
import { Todo } from '../todo';
import { ActivatedRoute, Router } from '@angular/router';
import { TodoService } from '../todo.service';

@Component({
  selector: 'app-update-todo',
  templateUrl: './update-todo.component.html',
  styleUrls: ['./update-todo.component.css']
})
export class UpdateTodoComponent implements OnInit {

  id: number;
  todo: Todo;

  constructor(private route: ActivatedRoute,private router: Router,
    private todoService: TodoService) { }

  ngOnInit() {
    this.todo = new Todo();

    this.id = this.route.snapshot.params['id'];
    
    this.todoService.getTodo(this.id)
      .subscribe(data => {
        console.log(data)
        this.todo = data;
      }, error => console.log(error));
  }

  updateTodo() {
    this.todoService.updateTodo(this.id, this.todo)
      .subscribe(data => console.log(data), error => console.log(error));
      //Using Time out as angular is asyn and get-list is getting called before save/update is committed
    setTimeout(() => {
      console.log('sleep');
      this.gotoList();
      // And any other code that should run only after 5s
    }, 2000);
    this.gotoList();
  }

  onSubmit() {
    this.updateTodo();    
  }

  gotoList() {
    this.router.navigate(['/get-todo-listing']);
  }
}