import styled, { css } from 'styled-components';

import { primaryColor, secondaryColor } from '../../colors';

export const ButtonGroup = styled.section`
  display: grid;
  grid-gap: 1.5rem;
  width: 100%;
`;

const gradientText = css`
  background-color: #fff;

  span {
    background: -webkit-linear-gradient(
      45deg,
      ${primaryColor},
      ${secondaryColor}
    );
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
  }
`;

const gradientBackground = css`
  background-image: linear-gradient(170deg, ${primaryColor}, ${secondaryColor});
  color: #fff;
`;

const normal = css`
  background-color: #fff;
  color: #444;
`;

export const Container = styled.button`
  border: none;
  border-radius: 9999px;
  font-size: 1rem;
  font-weight: bold;
  padding: 0.875rem 1.25rem;
  text-transform: uppercase;
  width: ${(props) => (props.variant ? 'auto' : '100%')};

  ${(props) =>
    props.gradientText
      ? gradientText
      : props.normal
      ? normal
      : gradientBackground};
`;
