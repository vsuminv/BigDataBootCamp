import { useRouter} from 'next/router'
import React from 'react'

function  ClientPhonePage() {
    const router =   useRouter();
  return (
        <div>{router.query.name} : {router.query.phone}</div>
  )
}

export default  ClientPhonePage
