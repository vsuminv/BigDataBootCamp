import React, { useState } from 'react'
import styles from './Todo.module.css'
import GarbageIcon from '../../../public/static/svg/garbage.svg'

const Todo = (props) => {
    // todo 완료 체크 여부, check state
    const [isCompleted, setIsCompleted] = useState(false);

    // todo 완료 체크 값 변경 핸들러 함수
    const checkHandler = () => {
        setIsCompleted(!isCompleted);
    }

    //todo  삭제
    const deleteTodo = async () =>{
      // console.log("deleteTodo")
      props.deleteTodo(props.id); //Todos 컴포넌트에서 props를 통해 내려받은 핸들러 함수 호출, 
      //인자 값으로 id 값 전달 -> lifting state up
     
    }


  return (
    <li className={styles.todo}>
        <input className={styles.toggle} type="checkbox" checked={isCompleted} onChange={checkHandler}/>
        <label className={`${styles['todo-title']} ${isCompleted && styles['todo-is-completed']}`}>{props.id} - {props.title}</label>
        <GarbageIcon onClick ={deleteTodo} className={styles.delete}/>
    </li>
  )
}

export default Todo;