// src/App.js
import React from 'react';
import Frame from './components/frame.js';
import CadastroProcesso from './CadastroProcesso';
import './CadastroProcesso.css';

function App() {
  return (
    <Frame>
      <CadastroProcesso />
    </Frame>
  );
}

export default App;