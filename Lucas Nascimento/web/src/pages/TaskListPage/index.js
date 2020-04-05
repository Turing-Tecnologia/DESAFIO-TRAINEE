import React, { useCallback } from 'react';
import { useHistory } from 'react-router-dom';

import Container from '../../components/Container';
import ScrollContainer, { ShowMore } from '../../components/ScrollContainer';
import Button from '../../components/Button';
import Title from '../../components/Title';
import Task from './Task';

export default function TaskListPage() {
  const history = useHistory();
  const handleClick = useCallback(() => history.push('/app/tasks/done'), [
    history,
  ]);

  return (
    <Container>
      <Title>Tarefas</Title>

      <ScrollContainer>
        <Task />
        <Task />
        <Task />

        <ShowMore>Mostrar mais 13 tarefas</ShowMore>
      </ScrollContainer>

      <Button onClick={handleClick} text="Tarefas concluídas" />
    </Container>
  );
}
