import React from 'react';

import Container from '../../components/Container';
import Button, { ButtonGroup } from '../../components/Button';
import { AvatarContainer, Avatar, Input } from './styles';

export default function UserPage() {
  return (
    <Container>
      <AvatarContainer>
        <Avatar src="https://pm1.narvii.com/6279/c42f623be3d71b57c8c3fcaa2d03c182ee824dd0_hq.jpg" />
        <button />
      </AvatarContainer>

      <ButtonGroup>
        <Input name="nome" value="Felipp Júnior" />
        <Input name="email" value="felipjunior@ufersa.com" />
        <Button text="Alterar senha" />
      </ButtonGroup>

      <Button text="Salvar" variant />
    </Container>
  );
}
