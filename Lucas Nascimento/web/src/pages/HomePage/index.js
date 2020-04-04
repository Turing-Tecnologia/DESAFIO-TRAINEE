import React, { useCallback } from 'react';
import { useHistory } from 'react-router-dom';

import Container from '../../components/Container';
import Logo from '../../components/Logo';
import Button, { ButtonGroup } from '../../components/Button';

export default function HomePage() {
  const history = useHistory();

  const handleClick = useCallback(
    (route) => {
      history.push(route);
    },
    [history]
  );

  return (
    <Container>
      <Logo />

      <ButtonGroup>
        <Button onClick={() => handleClick('/signup')} text="Criar conta" />
        <Button text="Entrar com o Google" normal disabled />
      </ButtonGroup>

      <Button
        onClick={() => handleClick('/signin')}
        text="Login"
        gradientText
      />
    </Container>
  );
}
