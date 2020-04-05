import React, { useState, useCallback } from 'react';

import Container from '../../components/Container';
import { Input, Textarea, Button, Buttons } from './styles';

import check from '../../assets/img/check.png';
import trash from '../../assets/img/trash.png';

export default function CreateTaskPage() {
  const [displayDate, setDisplayDate] = useState(false);

  const handleClick = useCallback(() => setDisplayDate(true), []);

  return (
    <Container>
      <section>
        <Input value="Trabalho" />
        <Textarea placeholder="Adicionar descrição" cols="30" rows="5" />

        {displayDate ? (
          <Input type="datetime-local" />
        ) : (
          <Button onClick={handleClick}>Adicionar data e hora</Button>
        )}
      </section>

      <Buttons>
        <button>
          <img src={check} alt="Ícone de certo" />
        </button>
        <button>
          <img src={trash} alt="Ícone de lixeira" />
        </button>
      </Buttons>
    </Container>
  );
}
