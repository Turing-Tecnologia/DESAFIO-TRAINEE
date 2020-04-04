import React, { useCallback } from 'react';
import { useHistory } from 'react-router-dom';

import Container from '../../components/Container';
import Logo from '../../components/Logo';
import Button, { ButtonGroup } from '../../components/Button';

export default function HomePage() {
  const history = useHistory();

  const handleSignUpClick = useCallback(() => {
    history.push('/signup');
  }, [history]);

  return (
    <Container>
      <Logo />

      <ButtonGroup>
        <Button onClick={handleSignUpClick} text="Criar conta" />
        <Button normal disabled text="Entrar com o Google" />
      </ButtonGroup>

      <Button gradientText text="Login" />
    </Container>
  );
}
