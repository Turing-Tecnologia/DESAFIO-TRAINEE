import React, { useState, useEffect, useCallback, useRef } from 'react';

import Container, { Message } from '../../components/Container';
import Button, { ButtonGroup } from '../../components/Button';
import { AvatarContainer, Avatar, Input, Form } from './styles';

import { getToken } from '../../services/auth';
import { getUserByToken, updateUser } from '../../services/api';

export default function ProfileEditPage() {
  const [displayPass, setDisplayPass] = useState(false);
  const [message, setMessage] = useState();
  const [user, setUser] = useState({});

  const nameRef = useRef();
  const emailRef = useRef();
  const passwordRef = useRef();

  useEffect(() => {
    getUserByToken(getToken()).then(({ data }) => setUser(data));
  }, []);

  const handleSubmit = useCallback(
    (event) => {
      event.preventDefault();

      const newUser = {
        id: user.id,
        name: nameRef.current.value,
      };

      if (emailRef.current.value !== user.email)
        newUser.email = emailRef.current.value;
      if (passwordRef.current) newUser.password = passwordRef.current.value;

      updateUser(newUser)
        .then(({ data }) => {
          setMessage({ text: 'Sucesso ao editar perfil', success: true });
          setUser(data);
        })
        .catch(({ response }) =>
          setMessage({ text: response.data.message, success: false })
        );
    },
    [user]
  );

  const handleClick = useCallback(() => setDisplayPass(true), []);

  return (
    <Container>
      {message && <Message success={message.success}>{message.text}</Message>}
      <AvatarContainer>
        <Avatar
          src={
            user.avatar_url ||
            'https://pm1.narvii.com/6279/c42f623be3d71b57c8c3fcaa2d03c182ee824dd0_hq.jpg'
          }
        />
        <button />
      </AvatarContainer>

      <Form onSubmit={handleSubmit}>
        <ButtonGroup>
          <Input
            placeholder="Digite seu nome"
            name="nome"
            ref={nameRef}
            defaultValue={user.name}
          />
          <Input
            placeholder="Digite um e-mail"
            name="email"
            ref={emailRef}
            defaultValue={user.email}
          />

          {displayPass ? (
            <Input
              placeholder="Digite uma senha"
              name="password"
              type="password"
              ref={passwordRef}
            />
          ) : (
            <Button onClick={handleClick} text="Alterar senha" />
          )}
        </ButtonGroup>

        <Button type="submit" text="Salvar" variant />
      </Form>
    </Container>
  );
}
