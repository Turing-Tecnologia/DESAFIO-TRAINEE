import styled from 'styled-components';

import DefaultInput from '../../components/Input';

import { primaryColor } from '../../colors';

export const Avatar = styled.img`
  border: 2px solid ${primaryColor};
  border-radius: 50%;
  height: 180px;
  object-fit: cover;
  object-position: center;
  width: 180px;

  &::after {
    content: ' ';
  }
`;

export const AvatarContainer = styled.section`
  position: relative;
  margin-bottom: 2rem !important;

  ${Avatar} + button {
    border: none;
    border-radius: 50%;
    bottom: 0px;
    background-color: #fff;
    height: 40px;
    position: absolute;
    right: 1.5rem;
    width: 40px;
  }
`;

export const Input = styled(DefaultInput)`
  text-align: center;
`;

export const Form = styled.form`
  width: 100%;

  & > button:last-child {
    display: block;
    margin: auto;
    margin-top: 4rem;
  }
`;
