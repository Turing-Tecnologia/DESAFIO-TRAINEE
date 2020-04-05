import styled, { css } from 'styled-components';

const styles = css`
  border: none;
  background: none;
  color: #fff;
  font-size: 1rem;
  margin-bottom: 1.5rem !important;
  width: 100%;

  &::placeholder {
    color: #fff;
  }
`;

export const Input = styled.input`
  ${styles}

  &:first-child {
    font-size: 1.75rem;
  }
`;

export const Textarea = styled.textarea`
  ${styles}
`;

export const Button = styled.button`
  ${styles}
  text-align: left;
`;

export const Buttons = styled.section`
  display: grid;
  grid-gap: 1.5rem;
  margin-left: auto;

  button {
    align-items: center;
    background: #fff;
    border: none;
    border-radius: 50%;
    display: flex;
    height: 4rem;
    justify-content: center;
    width: 4rem;
  }
`;
