import styled from 'styled-components';

import { backgroundColor } from '../../colors';

export const Wrapper = styled.main`
  background-color: ${backgroundColor};
`;

export const Content = styled.div`
  align-items: center;
  display: flex;
  flex-direction: column;
  justify-content: center;
  margin: auto;
  max-width: 362px;
  min-height: 100vh;
  padding: 1rem 2.5rem;
  position: relative;

  & > *:not(:last-child) {
    margin-bottom: 5rem;
  }
`;

export const Message = styled.span`
  background-color: rgba(12, 12, 12, 0.875);
  bottom: 0px;
  color: #b44;
  font-size: 0.75rem;
  font-size: bold;
  left: 0px;
  line-height: 2;
  margin: 0px !important;
  padding: 0.5rem;
  position: fixed;
  text-align: center;
  width: 100%;
  z-index: 5;
`;
