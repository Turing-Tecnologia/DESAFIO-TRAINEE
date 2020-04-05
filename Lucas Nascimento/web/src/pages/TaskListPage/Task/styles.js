import styled from 'styled-components';

export const Container = styled.div`
  align-items: center;
  background-color: ${(props) => (props.clicked ? '#222' : '#fff')};
  border-radius: ${(props) => (props.clicked ? '10px' : '0px')};
  color: ${(props) => (!props.clicked ? '#222' : '#fff')};
  display: ${(props) => (props.clicked ? 'block' : 'flex')};
  border-bottom: 1px solid #ccc;
  justify-content: space-between;
  margin: ${(props) => (props.clicked ? '1rem 0px' : '0px')};
  padding: 1rem 0.5rem;
  transition: 0.3s ease;
`;

export const Title = styled.h3`
  font-size: 1rem;
  font-weight: normal;
  margin: 0px;
  margin-right: 0.875rem;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
`;

export const Text = styled.h3`
  font-size: 0.75rem;
  font-weight: normal;
  line-height: 1.5;
  margin: 0px;
  padding: 0px 0.5rem;
`;

export const Date = styled.h4`
  font-size: 0.75rem;
  font-weight: normal;
  margin: 0px;
  min-width: 42px;
  text-align: right;
`;

export const Button = styled.button`
  background: none;
  border: none;
  color: #4b4;
  margin-top: 2rem;
  padding: 0.5rem;
  width: 50%;

  &:nth-child(3) {
    color: #b44;
  }
`;
