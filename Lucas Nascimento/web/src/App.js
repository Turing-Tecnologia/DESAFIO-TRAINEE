import React from 'react';
import { BrowserRouter as Router } from 'react-router-dom';

import GlobalStyle from './styles/GlobalStyle';
import Routes from './routes';

export default function App() {
  return (
    <Router>
      <GlobalStyle />
      <Routes />
    </Router>
  );
}
