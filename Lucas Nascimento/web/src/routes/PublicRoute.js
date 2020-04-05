import React from 'react';
import { Route, Redirect } from 'react-router-dom';

import { getToken } from '../services/auth';

export default function PublicRoute({ ...props }) {
  if (getToken()) {
    return <Redirect to="/app" />;
  }

  return <Route {...props} />;
}
