import React, { useCallback, useRef, useState } from 'react';
import { useHistory } from 'react-router-dom';

import Container, { Message } from '../../components/Container';
import Logo from '../../components/Logo';
import Button, { ButtonGroup } from '../../components/Button';
import Input from '../../components/Input';
import { Form } from './styles';

import { loginUser } from '../../services/api';
import { signInToken } from '../../services/auth';

export default function SignInPage() {
  const history = useHistory();
  const [message, setMessage] = useState();

  const emailRef = useRef();
  const passwordRef = useRef();

  const handleSubmit = useCallback(
    (event) => {
      event.preventDefault();

      const user = {
        email: emailRef.current.value,
        password: passwordRef.current.value,
      };
      loginUser(user)
        .then(({ data }) => {
          signInToken(data.token);
          history.push('/app');
        })
        .catch(({ response }) => setMessage(response.data.message));
    },
    [history]
  );

  return (
    <Container>
      {message && <Message>{message}</Message>}
      <Logo />

      <Form onSubmit={handleSubmit}>
        <ButtonGroup>
          <Input
            ref={emailRef}
            name="email"
            placeholder="E-mail"
            type="email"
          />
          <Input
            ref={passwordRef}
            name="password"
            placeholder="Senha"
            type="password"
          />
        </ButtonGroup>

        <Button type="submit" text="Login" gradientText variant />
      </Form>
    </Container>
  );
}
