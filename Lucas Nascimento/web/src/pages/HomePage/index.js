import React from 'react';

import Container from '../../components/Container';
import Button, { ButtonGroup } from '../../components/Button';
import { Logo } from './styles';

import logo from '../../assets/img/logo.png';

export default function HomePage() {
  return (
    <Container>
      <Logo src={logo} />

      <ButtonGroup>
        <Button text="Criar conta" />
        <Button normal disabled text="Entrar com o Google" />
      </ButtonGroup>

      <Button gradientText text="Login" />
    </Container>
  );
}
