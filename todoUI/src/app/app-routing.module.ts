import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TodoListComponent } from './todo-list/todo-list.component';
import { CreateTodoComponent } from './create-todo/create-todo.component';
import { UpdateTodoComponent } from './update-todo/update-todo.component';
import { TodoDetailsComponent } from './todo-details/todo-details.component';


const routes: Routes = [

  { path: '', redirectTo: 'todo', pathMatch: 'full' },
  { path: 'get-todo-listing', component: TodoListComponent },
  { path: 'add', component: CreateTodoComponent },
  { path: 'update-todo/:id', component: UpdateTodoComponent },
  { path: 'get-todo-by-id/:id', component: TodoDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
