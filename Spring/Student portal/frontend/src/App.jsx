import { useState, useEffect } from 'react'
import './App.css'

function App() {
  const [name, setName] = useState('')
  const [email, setEmail] = useState('')
  const [pass, setPass] = useState('')
  const [phone, setPhone] = useState('')
  const [students, setStudents] = useState([])

  // fetch students from backend
  const loadStudents = () => {
    fetch('http://localhost:8080/students')
      .then((res) => res.json())
      .then((data) => setStudents(data))
      .catch((err) => console.log(err))
  }

  // load on page open
  useEffect(() => {
    loadStudents()
  }, [])

  // submit form
  const handleSubmit = (e) => {
    e.preventDefault()

    fetch('http://localhost:8080/students', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ name, email, password: pass, phone })
    })
      .then(() => {
        loadStudents()
        setName('')
        setEmail('')
        setPass('')
        setPhone('')
      })
      .catch((err) => console.log(err))
  }

  return (
    <div className="container">
      <h1>student registration portal</h1>

      <form onSubmit={handleSubmit} className="form-row">
        <input
          type="text"
          placeholder="enter your name"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
        <input
          type="email"
          placeholder="enter ur email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />
        <input
          type="password"
          placeholder="enter ur password"
          value={pass}
          onChange={(e) => setPass(e.target.value)}
        />
        <input
          type="text"
          placeholder="enter ur phone number"
          value={phone}
          onChange={(e) => setPhone(e.target.value)}
        />
        <button type="submit">Submit</button>
      </form>

      <h2>students registered:</h2>

      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>email</th>
            <th>Phone</th>
          </tr>
        </thead>
        <tbody>
          {students.map((s) => (
            <tr key={s.id}>
              <td>{s.id}</td>
              <td>{s.name}</td>
              <td>{s.email}</td>
              <td>{s.phone}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  )
}

export default App
