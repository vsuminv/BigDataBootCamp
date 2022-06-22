import React from 'react'
import Todo from './Todo/Todo';

const Todos = (props) => {

    // delteTodo
    const deleteTodo = (id) => {
        console.log("Todos의 deleteTodo")
        props.deleteTodo(id); //Main.js에서 받은
    }
    const todos = props.todos.map(todo => (
        <Todo 
            key={todo.id} 
            id={todo.id} 
            title={todo.title} 
            descripton={todo.descripton} 
            deleteTodo={deleteTodo}
            />
    ));
    return (
        <ul>
            {todos}
        </ul>
    )
}

export default Todos
