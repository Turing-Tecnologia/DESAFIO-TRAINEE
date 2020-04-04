import React from 'react';

import Container from '../../components/Container';
import Logo from '../../components/Logo';
import Button, { ButtonGroup } from '../../components/Button';
import Input from '../../components/Input';

export default function SignInPage() {
  return (
    <Container>
      <Logo />

      <ButtonGroup>
        <Input name="email" placeholder="E-mail" type="email" />
        <Input name="password" placeholder="Senha" type="password" />
      </ButtonGroup>

      <Button text="Login" gradientText variant />
    </Container>
  );
}
