import React from 'react';

import { Container, ButtonGroup } from './styles';

export default function Button({ onClick, text, ...rest }) {
  return (
    <Container onClick={onClick} {...rest}>
      <span>{text}</span>
    </Container>
  );
}

export { ButtonGroup };
