import React from 'react';

import Container from '../../components/Container';
import ScrollContainer, { ShowMore } from '../../components/ScrollContainer';
import Button from '../../components/Button';
import Title from '../../components/Title';
import Task from './Task';

export default function TaskListPage() {
  return (
    <Container>
      <Title>Tarefas</Title>

      <ScrollContainer>
        <Task />
        <Task />
        <Task />

        <ShowMore>Mostrar mais 13 tarefas</ShowMore>
      </ScrollContainer>

      <Button text="Tarefas concluídas" />
    </Container>
  );
}
