
import { BrowserRouter, Routes, Route } from "react-router-dom";
import './App.css';
import Quiz from './components/Quiz.js';
import Score from "./components/Score.js";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Quiz />} />
          <Route path="Score" element={<Score />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
