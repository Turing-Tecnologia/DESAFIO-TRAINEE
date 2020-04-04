import React from 'react';
import { Switch, Route } from 'react-router-dom';

import HomePage from '../pages/HomePage';
import SignUpPage from '../pages/SignUpPage';
import SignInPage from '../pages/SignInPage';

export default function Routes() {
  return (
    <Switch>
      <Route path="/" exact component={HomePage} />
      <Route path="/signup" exact component={SignUpPage} />
      <Route path="/signin" exact component={SignInPage} />
    </Switch>
  );
}
