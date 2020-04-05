import React, { useState, useCallback } from 'react';
import { useHistory } from 'react-router-dom';

import { Container, Title, Date, Text, Button } from './styles';

import { updateTask, deleteTask } from '../../../services/api';

export default function Task({ id, title, datetime, text, userId }) {
  const [clicked, setClicked] = useState(false);
  const history = useHistory();
  const handleClick = useCallback(() => setClicked(!clicked), [clicked]);

  const handleDone = useCallback(() => {
    updateTask(id, userId, { done: true }).then(() => {
      history.push('/app/tasks/done');
    });
  }, [id, userId, history]);

  const handleDelete = useCallback(() => {
    deleteTask(id, userId).then(() => {
      history.push('/app');
    });
  }, [id, userId, history]);

  const asDate = new window.Date(datetime);

  return (
    <Container clicked={clicked}>
      {clicked ? (
        <>
          <Text onClick={handleClick}>{text || 'Sem descrição'}</Text>
          <Button onClick={handleDone}>Concluir</Button>
          <Button onClick={handleDelete}>Excluir</Button>
        </>
      ) : (
        <>
          <Title onClick={handleClick}>{title}</Title>
          {datetime && (
            <Date>
              {getMonth(asDate.getMonth())}, {asDate.getDay()}
            </Date>
          )}
        </>
      )}
    </Container>
  );
}

function getMonth(month) {
  if (month === 0) return 'Jan';
  if (month === 1) return 'Fev';
  if (month === 2) return 'Mar';
  if (month === 3) return 'Abr';
  if (month === 4) return 'Mai';
  if (month === 5) return 'Jun';
  if (month === 6) return 'Jul';
  if (month === 7) return 'Ago';
  if (month === 8) return 'Set';
  if (month === 9) return 'Out';
  if (month === 10) return 'Nob';
  if (month === 11) return 'Dez';
}
