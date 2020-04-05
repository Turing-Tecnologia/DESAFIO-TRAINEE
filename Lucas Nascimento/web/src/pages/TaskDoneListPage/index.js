import React from 'react';

import Container from '../../components/Container';
import ScrollContainer, { ShowMore } from '../../components/ScrollContainer';
import Title from '../../components/Title';
import Task from './Task';

export default function TaskDoneListPage() {
  return (
    <Container>
      <Title>Tarefas concluídas</Title>

      <ScrollContainer>
        <Task />
        <Task />
        <Task />

        <ShowMore>Mostrar mais 6 tarefas</ShowMore>
      </ScrollContainer>

      <span />
    </Container>
  );
}
