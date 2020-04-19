import React, { useCallback, useEffect, useState } from 'react';
import { useHistory } from 'react-router-dom';

import Container from '../../components/Container';
import Button, { ButtonGroup } from '../../components/Button';
import { Avatar } from './styles';

import { getToken } from '../../services/auth';
import { getUserByToken } from '../../services/api';

export default function UserPage() {
  const history = useHistory();
  const [user, setUser] = useState({});
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    getUserByToken(getToken()).then(({ data }) => {
      setUser(data);
      setLoading(false);
    });
  }, []);

  const handleClick = useCallback((route) => history.push(route), [history]);

  return (
    <Container loading={loading}>
      <Avatar
        src={
          user.avatar_url ||
          'https://pm1.narvii.com/6279/c42f623be3d71b57c8c3fcaa2d03c182ee824dd0_hq.jpg'
        }
      />

      <ButtonGroup>
        <Button
          onClick={() => handleClick('/app/profile')}
          text="Editar perfil"
        />

        <Button onClick={() => handleClick('/app/tasks')} text="Tarefas" />

        <Button
          onClick={() => handleClick('/app/tasks/new')}
          text="Criar"
          gradientText
        />
      </ButtonGroup>
    </Container>
  );
}
