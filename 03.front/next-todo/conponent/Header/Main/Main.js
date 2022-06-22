import React  from "react";
import Todos from "../../Todos/Todos";
import styles from './Main.module.css'
import PlusIcon from '../../../public/static/svg/plus.svg';
import {useRouter } from "next/router";

const Main = (props) => {
    const todos = props.todos;
    // console.log(todos);
    const router = useRouter();

    //Add todo
    const addTodo = () => {
        console.log('addTodo');
        router.push('/todo/add');
    }

    // DeletTOdo
    const deleteTodo = (id) => {
        props.deleteTodo(id); //pages/index.js 에서 내려보내준 deleteTodo 호출
    }

    return (
        <>
            <div className={styles["todo-header"]}>
                <PlusIcon  className={styles['new-todo ']} onClick={addTodo}/>
                <input className={styles['search-todo']} 
                type="text" placeholder="what needs to be done?" autoFocus/> 
            </div>
            <Todos 
                todos = {props.todos} 
                deleteTodo = {deleteTodo}
                />
        </>

    );
};
export default Main;