import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8080',
  headers: {
    'Content-Type': 'application/json',
  },
});

export const createUser = (user) => api.post('/users', { ...user });

export const loginUser = (user) => api.post('/auth', { ...user });
