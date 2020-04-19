import styled from 'styled-components';

import logo from '../../assets/img/logo.png';

const Logo = styled.img`
  height: auto;
  width: 130px;
`;

Logo.defaultProps = {
  src: logo,
};

export default Logo;
