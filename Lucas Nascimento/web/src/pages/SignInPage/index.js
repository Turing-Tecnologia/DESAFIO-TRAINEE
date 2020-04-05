import React, { useCallback } from 'react';
import { useHistory } from 'react-router-dom';

import Container from '../../components/Container';
import Logo from '../../components/Logo';
import Button, { ButtonGroup } from '../../components/Button';
import Input from '../../components/Input';

export default function SignInPage() {
  const history = useHistory();
  const handleClick = useCallback(() => history.push('/app'), [history]);

  return (
    <Container>
      <Logo />

      <ButtonGroup>
        <Input name="email" placeholder="E-mail" type="email" />
        <Input name="password" placeholder="Senha" type="password" />
      </ButtonGroup>

      <Button onClick={handleClick} text="Login" gradientText variant />
    </Container>
  );
}
