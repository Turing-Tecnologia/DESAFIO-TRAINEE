import styled, { keyframes } from 'styled-components';

import { backgroundColor, primaryColor, secondaryColor } from '../../colors';

export const Wrapper = styled.main`
  align-items: center;
  background-color: ${backgroundColor};
  display: flex;
  justify-content: center;
  min-height: 100vh;
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
  color: ${(props) => (props.success ? '#4b4' : '#b44')};
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

const rotate = keyframes`
  0% {
    border-color: ${primaryColor};
    transform: rotate(0deg);
  }

  50% {
    border-color: ${secondaryColor};
  }

  100% {
    border-color: ${primaryColor};
    transform: rotate(360deg);
  }
`;

const background = keyframes`
  0% {
    background-color: ${primaryColor};
  }

  50% {
    background-color: ${secondaryColor};
  }

  100% {
    background-color: ${primaryColor};
  }
`;

export const Loading = styled.span`
  animation: ${rotate} 0.75s linear infinite forwards;
  background-color: transparent;
  border: 4px solid;
  border-radius: 50%;
  padding: 4rem;
  position: relative;

  &::after {
    animation: ${background} 0.75s linear infinite forwards;
    border-radius: 50%;
    content: ' ';
    height: 4rem;
    left: 0;
    position: absolute;
    width: 4rem;
  }
`;
