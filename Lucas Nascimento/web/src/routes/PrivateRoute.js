import React, { useState, useEffect } from 'react';
import { Route, Redirect } from 'react-router-dom';

import Container from '../components/Container';

import { getToken, removeToken } from '../services/auth';
import { validateToken } from '../services/api';

export default function PrivateRoute({ ...props }) {
  const [loading, setLoading] = useState(true);
  const [allowed, setAllowed] = useState(false);

  useEffect(() => {
    const token = getToken();
    if (!token) {
      setAllowed(false);
      setLoading(false);
      return;
    }

    validateToken(token).then(({ data }) => {
      setAllowed(data.valid);

      if (!data.valid) removeToken();

      setLoading(false);
    });
  }, []);

  return loading ? (
    <Container loading={true} />
  ) : allowed ? (
    <Route {...props} />
  ) : (
    <Redirect to="/" />
  );
}
