import React, { useCallback, useRef, useState } from 'react';
import { useHistory } from 'react-router-dom';

import Container, { Message } from '../../components/Container';
import Logo from '../../components/Logo';
import Button, { ButtonGroup } from '../../components/Button';
import Input from '../../components/Input';
import { Form } from './styles';

import { createUser } from '../../services/api';

export default function SignUpPage() {
  const history = useHistory();
  const [message, setMessage] = useState();
  const [loading, setLoading] = useState(false);

  const emailRef = useRef();
  const passwordRef = useRef();
  const confirmPassRef = useRef();

  const handleSubmit = useCallback(
    (event) => {
      event.preventDefault();
      setLoading(true);

      const password = passwordRef.current.value;
      const passwordConfirm = confirmPassRef.current.value;

      if (password !== passwordConfirm) {
        setMessage('As senhas não coincidem');
        setLoading(false);
        return;
      } else setMessage(null);

      const email = emailRef.current.value;
      createUser({ email, password })
        .then(() => history.push('/signin'))
        .catch(({ response }) => setMessage(response.data.message))
        .then(() => setLoading(false));
    },
    [history]
  );

  return (
    <Container loading={loading}>
      {message && <Message>{message}</Message>}

      <Logo />

      <Form onSubmit={handleSubmit}>
        <ButtonGroup>
          <Input
            name="email"
            placeholder="Digite seu e-mail"
            type="email"
            ref={emailRef}
          />
          <Input
            name="password"
            placeholder="Crie uma senha"
            type="password"
            ref={passwordRef}
          />
          <Input
            placeholder="Confirme a senha"
            type="password"
            ref={confirmPassRef}
          />

          <Button type="submit" text="Criar conta" variant />
        </ButtonGroup>
      </Form>
    </Container>
  );
}
