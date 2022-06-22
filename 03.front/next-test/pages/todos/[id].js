import React from 'react'
import {useRouter} from 'next/router'
const TodoDatailPage = () => {
    const router = useRouter();
    console.log(router.pathname);
    console.log('query', router.query);
    console.log('query id', router.query.id);
    console.log('asPath', router.asPath);
    


  return (
    <div>
        <div>TodoDatailPage</div>
    </div>
  )
}

export default TodoDatailPage
