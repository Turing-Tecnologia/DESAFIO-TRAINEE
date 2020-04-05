import React, { useCallback } from 'react';
import { useHistory } from 'react-router-dom';

import Container from '../../components/Container';
import Button, { ButtonGroup } from '../../components/Button';
import Input from '../../components/Input';
import { Avatar } from './styles';

export default function UserPage() {
  const history = useHistory();

  const handleClick = useCallback((route) => history.push(route), [history]);

  return (
    <Container>
      <Avatar src="https://pm1.narvii.com/6279/c42f623be3d71b57c8c3fcaa2d03c182ee824dd0_hq.jpg" />

      <ButtonGroup>
        <Button
          onClick={() => handleClick('/app/profile')}
          text="Editar perfil"
        />
        <Button onClick={() => handleClick('/app/tasks')} text="Tarefas" />
        <Button text="Criar" gradientText />
      </ButtonGroup>
    </Container>
  );
}
