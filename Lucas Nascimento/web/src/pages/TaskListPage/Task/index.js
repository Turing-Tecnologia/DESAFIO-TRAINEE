import React from 'react';

import { Container, Title, Date } from './styles';

export default function Task({ title, datetime }) {
  const asDate = new window.Date(datetime);

  return (
    <Container>
      <Title>{title}</Title>
      {datetime && (
        <Date>
          {getMonth(asDate.getMonth())}, {asDate.getDay()}
        </Date>
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
