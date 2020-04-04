import React from 'react';
import { Switch, Route } from 'react-router-dom';

import HomePage from '../pages/HomePage';
import SignUpPage from '../pages/SignUpPage';

export default function Routes() {
  return (
    <Switch>
      <Route path="/" exact component={HomePage} />
      <Route path="/signup" exact component={SignUpPage} />
    </Switch>
  );
}
