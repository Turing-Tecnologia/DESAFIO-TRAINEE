import { createGlobalStyle } from 'styled-components';

const GlobalStyle = createGlobalStyle`
  body {
    margin: 0px;
    padding: 0px;
  }

  body, button, input {
    font-family: 'Poppins', sans-serif;
    line-height: 1;
  }

  * {
    box-sizing: border-box;
    outline: none;
  }

  a {
    color: inherit;
    text-decoration: none;
  }

  ul {
    list-style: none;
    margin: 0px;
    padding: 0px;
  }

  button {
    cursor: pointer;
  }
`;

export default GlobalStyle;
