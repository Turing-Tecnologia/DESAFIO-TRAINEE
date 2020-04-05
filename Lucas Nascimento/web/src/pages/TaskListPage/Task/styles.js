import styled from 'styled-components';

export const Container = styled.div`
  align-items: center;
  display: flex;
  border-bottom: 1px solid #ccc;
  justify-content: space-between;
  padding: 1rem 0.5rem;
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

export const Date = styled.h4`
  font-size: 0.75rem;
  font-weight: normal;
  margin: 0px;
  min-width: 42px;
  text-align: right;
`;
