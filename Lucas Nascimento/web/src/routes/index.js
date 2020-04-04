import React from 'react';
import { Switch, Route } from 'react-router-dom';

import HomePage from '../pages/HomePage';

export default function Routes() {
  return (
    <Switch>
      <Route path="/" component={HomePage} />
    </Switch>
  );
}
