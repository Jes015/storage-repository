import { CssVarsProvider } from '@mui/joy/styles'
import CssBaselinse from '@mui/joy/CssBaseline'
import React from 'react'
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'
import Header from './components/Header'

export default function App () {
  return (
    <CssVarsProvider defaultMode='dark' modeStorageKey='mode-toggle-demo'>
      <CssBaselinse />
      <div>
        <Header />
        <Router>
          <Routes>
            <Route path='/bro' element={<h1>Hola bro</h1>} />
            <Route path='/' element={<h1>Hola home</h1>} />
          </Routes>
        </Router>
      </div>
    </CssVarsProvider>
  )
}
