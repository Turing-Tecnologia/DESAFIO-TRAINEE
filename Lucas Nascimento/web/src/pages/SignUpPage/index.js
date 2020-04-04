import React from 'react';

import Container from '../../components/Container';
import Logo from '../../components/Logo';
import Button, { ButtonGroup } from '../../components/Button';
import Input from '../../components/Input';

export default function SignUpPage() {
  return (
    <Container>
      <Logo />

      <ButtonGroup>
        <Input name="email" placeholder="Digite seu e-mail" type="email" />
        <Input name="password" placeholder="Crie uma senha" type="password" />
        <Input placeholder="Confirme a senha" type="password" />
      </ButtonGroup>

      <Button text="Criar conta" variant />
    </Container>
  );
}
