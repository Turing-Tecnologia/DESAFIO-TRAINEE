import React from 'react';
import { Switch, Route } from 'react-router-dom';

import HomePage from '../pages/HomePage';
import SignUpPage from '../pages/SignUpPage';
import SignInPage from '../pages/SignInPage';
import UserPage from '../pages/UserPage';
import ProfileEditPage from '../pages/ProfileEditPage';

export default function Routes() {
  return (
    <Switch>
      <Route path="/" exact component={HomePage} />
      <Route path="/signup" exact component={SignUpPage} />
      <Route path="/signin" exact component={SignInPage} />

      <Route path="/app" exact component={UserPage} />
      <Route path="/app/profile" exact component={ProfileEditPage} />
    </Switch>
  );
}
