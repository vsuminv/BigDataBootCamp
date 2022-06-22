import React from 'react'
import Link from 'next/link'

const ClientPage = () => {
  const clients = [
    {id : 'yoo', name : 'yoojaesuk'},
    {id : 'kang', name : 'kanghodong'},
    
  ]
  return (
    <>
    <div>ClientPage</div>
    {/* <ul>
      <li><Link href='/clients/you'>you</Link> </li>
    </ul> */}

    {/*2. React way */ }
    {/* <ul>
      {clients.map(client =>(
        <li key={client.id}>
          <Link href={`/clients${client.id}`} > {client.name}</Link>
        </li>
      ))}
    </ul> */}

    {/* 3. next way */}
    <ul>
      {clients.map(client => (
        <li key = {client.id}>
          <Link href={{
            pathname : '/clients/[name]',
            query : {name: client.name}
          }}>{client.name}</Link>
        </li>
      ))}
    </ul>
    </>
    
  )
}

export default ClientPage
