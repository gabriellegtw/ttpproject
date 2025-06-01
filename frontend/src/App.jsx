import { BrowserRouter, Routes, Route } from 'react-router-dom'
import PathGeneration from './pages/PathGeneration'
import ProfileCreation from './pages/ProfileCreation'
import ProgressPage from './pages/ProgressPage'
import './App.css'

function App() {
  return (
      <BrowserRouter>
          <Routes>
              {/* This route with path="/" is the default/home page */}
              <Route path="/" element={<ProfileCreation />} />
              <Route path="/path" element={<PathGeneration />} />
              <Route path="/progress" element={<ProgressPage />} />
          </Routes>
      </BrowserRouter>
  )
}

export default App
