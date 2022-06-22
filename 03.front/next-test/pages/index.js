import Head from 'next/head'
import Image from 'next/image'
import Link from 'next/link'
import styles from '../styles/Home.module.css'

export default function Home() {
  return (
    <>
      <div>localhost:3000/ 경로 실행되는</div>
      <ul>
        <li>
          <Link href="/todos">Todos</Link>
        </li>
        <li>
        <Link href="/clients">clients</Link>
        </li>
      </ul>
    </>
  )
}
