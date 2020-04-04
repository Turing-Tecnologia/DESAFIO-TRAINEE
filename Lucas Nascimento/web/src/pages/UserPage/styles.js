import styled from 'styled-components';

import { primaryColor } from '../../colors';

export const Avatar = styled.img`
  border: 2px solid ${primaryColor};
  border-radius: 50%;
  height: 180px;
  margin-bottom: 2rem !important;
  object-fit: cover;
  object-position: center;
  width: 180px;
`;
