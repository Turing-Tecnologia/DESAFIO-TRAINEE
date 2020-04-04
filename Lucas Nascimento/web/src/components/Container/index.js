import React from 'react';

import { Wrapper, Content } from './styles';

export default function Container({ children }) {
  return (
    <Wrapper>
      <Content>{children}</Content>
    </Wrapper>
  );
}
