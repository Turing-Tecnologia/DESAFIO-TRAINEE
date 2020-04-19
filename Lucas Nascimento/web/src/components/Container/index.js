import React from 'react';

import { Wrapper, Content, Message, Loading } from './styles';

export default function Container({ children, loading }) {
  return (
    <Wrapper>{loading ? <Loading /> : <Content>{children}</Content>}</Wrapper>
  );
}

export { Message };
