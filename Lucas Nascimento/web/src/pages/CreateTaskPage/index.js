import React, { useState, useCallback, useRef } from 'react';

import Container, { Message } from '../../components/Container';
import { Input, Textarea, Button, Buttons } from './styles';

import { getToken } from '../../services/auth';
import { createTask, getUserByToken } from '../../services/api';

import check from '../../assets/img/check.png';
import trash from '../../assets/img/trash.png';

export default function CreateTaskPage() {
  const [message, setMessage] = useState();
  const [displayDate, setDisplayDate] = useState(false);
  const handleClick = useCallback(() => setDisplayDate(true), []);

  const titleRef = useRef();
  const textRef = useRef();
  const datetimeRef = useRef();

  const handleCreate = useCallback(() => {
    const task = {
      title: titleRef.current.value,
      text: textRef.current.value,
    };

    if (datetimeRef.current) {
      task.datetime = datetimeRef.current.value;
      if (task.datetime === '') {
        setMessage({ text: 'Data e hora inválida', success: false });
        return;
      }
    }
    if (task.title === '') {
      setMessage({ text: 'Título inválida', success: false });
      return;
    }

    getUserByToken(getToken()).then(({ data }) => {
      createTask(task, data.id)
        .then(() =>
          setMessage({
            text: 'Tarefa criada com sucesso',
            success: true,
          })
        )
        .catch(({ response }) =>
          setMessage({ text: response.data.message, success: false })
        );
    });
  }, []);

  return (
    <Container>
      {message && <Message success={message.success}>{message.text}</Message>}
      <section>
        <Input
          ref={titleRef}
          placeholder="Adicionar título"
          defaultValue="Trabalho"
        />
        <Textarea
          ref={textRef}
          placeholder="Adicionar descrição"
          cols="30"
          rows="5"
        />

        {displayDate ? (
          <Input ref={datetimeRef} type="datetime-local" />
        ) : (
          <Button onClick={handleClick}>Adicionar data e hora</Button>
        )}
      </section>

      <Buttons>
        <button onClick={handleCreate}>
          <img src={check} alt="Ícone de certo" />
        </button>
        <button>
          <img src={trash} alt="Ícone de lixeira" />
        </button>
      </Buttons>
    </Container>
  );
}
